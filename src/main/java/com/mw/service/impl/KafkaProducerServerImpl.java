package com.mw.service.impl;

import com.alibaba.fastjson.JSON;
import com.mw.common.KafkaMesConstant;
import com.mw.service.IKafkaProducerServer;
import com.mw.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;

@Service
public class KafkaProducerServerImpl implements IKafkaProducerServer{

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public Map<String, Object> sendMesForTemplate(Object value,String username) {
        PropertiesUtil propertiesUtil = new PropertiesUtil("kafka.properties");
        String topic = propertiesUtil.get("topic");
        String ifPartition = propertiesUtil.get("ifPartition");
        Integer partitionNum = Integer.parseInt(propertiesUtil.get("partitionNum"));
        return this.sendMesForTemplate(topic,value,ifPartition,partitionNum,username);
    }

    public Map<String, Object> sendMesForTemplate(String topic, Object value, String ifPartition, Integer partitionNum, String role) {
        String key = role+"-"+value.hashCode();
        if(ifPartition.equals("0")){
            //表示使用分区
            int partitionIndex = getPartitionIndex(key, partitionNum);
            ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(topic, partitionIndex, key, value);
            Map<String,Object> res = checkProRecord(result);
            return res;
        }else{
            ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(topic, key, value);
            Map<String,Object> res = checkProRecord(result);
            return res;
        }
    }

    /**
     * 根据key值获取分区索引
     * @param key
     * @param partitionNum
     * @return
     */
    private int getPartitionIndex(String key, int partitionNum){
        if (key == null) {
            Random random = new Random();
            return random.nextInt(partitionNum);
        }
        else {
            int result = Math.abs(key.hashCode())%partitionNum;
            return result;
        }
    }

    /**
     * 检查发送返回结果record
     * @param res
     * @return
     */
    @SuppressWarnings("rawtypes")
    private Map<String,Object> checkProRecord(ListenableFuture<SendResult<String, String>> res){
        Map<String,Object> m = new HashMap<String,Object>();
        if(res!=null){
            try {
                SendResult r = res.get();//检查result结果集
                /*检查recordMetadata的offset数据，不检查producerRecord*/
                Long offsetIndex = r.getRecordMetadata().offset();
                if(offsetIndex!=null && offsetIndex>=0){
                    m.put("code", KafkaMesConstant.SUCCESS_CODE);
                    m.put("message", KafkaMesConstant.SUCCESS_MES);
                    return m;
                }else{
                    m.put("code", KafkaMesConstant.KAFKA_NO_OFFSET_CODE);
                    m.put("message", KafkaMesConstant.KAFKA_NO_OFFSET_MES);
                    return m;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                m.put("code", KafkaMesConstant.KAFKA_SEND_ERROR_CODE);
                m.put("message", KafkaMesConstant.KAFKA_SEND_ERROR_MES);
                return m;
            } catch (ExecutionException e) {
                e.printStackTrace();
                m.put("code", KafkaMesConstant.KAFKA_SEND_ERROR_CODE);
                m.put("message", KafkaMesConstant.KAFKA_SEND_ERROR_MES);
                return m;
            }
        }else{
            m.put("code", KafkaMesConstant.KAFKA_NO_RESULT_CODE);
            m.put("message", KafkaMesConstant.KAFKA_NO_RESULT_MES);
            return m;
        }
    }
}
