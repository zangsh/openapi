package com.mw.rest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mw.util.HBaseUtil;
import com.mw.util.MD5Util;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * kafka消费端
 */
public class KfkaConsumer implements MessageListener<String, String> {
    private final Logger logger = LoggerFactory.getLogger(KfkaConsumer.class);
    @Override
    public void onMessage(ConsumerRecord<String, String> record) {
        logger.info("=============kafkaConsumer开始消费 及 JSON解析=============");
        String topic = record.topic();
        String key = record.key();
        String value = record.value();
        long offset = record.offset();
        int partition = record.partition();
        //JSON解析,HBASE持久化
        JSONObject jsonObject = JSON.parseObject(value);
        logger.info("消费的kafka消息内容，持久化到hbase：" + jsonObject);
        JSONObject jsonRecord = jsonObject.getJSONObject("record");
        //获取用户名 ，备用拼接表名
        String username = jsonObject.getString("user");
        //获取业务数据数组
        JSONArray data = jsonRecord.getJSONArray("data");
        //数据将要存储的表名
        String tableName = jsonRecord.getString("tableName");
        String tableNameParam = (username + "_" + tableName).toUpperCase();
        HBaseUtil.createTable(tableNameParam);
        //迭代 JSONArray
        String dataStr = JSONObject.toJSONString(data, SerializerFeature.WriteClassName);
        List<HashMap> list = JSON.parseArray(dataStr,HashMap.class);
        for (Map m : list){
            //计算整体JSON的md5值作为primary key
            String md5Pk = MD5Util.MD5(m.toString());
            logger.info(md5Pk);
            for (Object s : m.keySet()){
                HBaseUtil.insert(tableNameParam,md5Pk,"0",s.toString().toUpperCase(),m.get(s).toString());
            }
            logger.info("数据存储完成！");
        }

        logger.info("-------------topic:" + topic);
        logger.info("-------------value:" + value);
        logger.info("-------------key:" + key);
        logger.info("-------------offset:" + offset);
        logger.info("-------------partition:" + partition);
        logger.info("~~~~~~~~~~~~~kafkaConsumer消费结束~~~~~~~~~~~~~");
    }


    public static String compress(String json) {
        if (json == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean skip = true;// true 允许截取(表示未进入string双引号)
        boolean escaped = false;// 转义符
        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);
            if (!escaped && c == '\\') {
                escaped = true;
            } else {
                escaped = false;
            }
            if (skip) {
                if (c == ' ' || c == '\r' || c == '\n' || c == '\t') {
                    continue;
                }
            }
            sb.append(c);
            if (c == '"' && !escaped) {
                skip = !skip;
            }
        }
        return sb.toString().replaceAll("\r\n", "\\\\r\\\\n");
    }
}
