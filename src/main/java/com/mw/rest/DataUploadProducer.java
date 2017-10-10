package com.mw.rest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.mw.service.IKafkaProducerServer;
import com.mw.service.IUserService;
import com.mw.util.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用Jersey2
 * 提供RESTful Web Service供企业传输数据
 * 到大数据平台
 * @version 1.0.0
 * @author zangsh
 */
@Path("/v1")
public class DataUploadProducer {
    //返回消息状态码
    private static final String success = "SUCCESS";
    private static final String fail = "FAIL";
    //返回消息内容
    private static final String jsonFail = "数据解析出错，请检查数据是否符合JSON格式！请联系管理人员";
    private static final String failMsg = "未知异常，请联系管理员";
    private static final String successMsg = "数据上传成功";
    private static final String userFail = "账号或密码错误";

    private static Logger logger = Logger.getLogger(DataUploadProducer.class);

    @Autowired
    private IUserService iUserService;
    @Autowired
    private IKafkaProducerServer iKafkaProducerServer;
    /**
     * 数据接收
     * @param json  传递的json格式数据
     * @return   是否成功，及对用的消息
     */
    @POST
    @Path("/msg")
    @Consumes(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String,Object> postData(String json){
        logger.debug("接收的数据JSON:" + json);
        Map<String,Object> returnMap = new HashMap<String,Object>();
        try {
            JSONObject jsonObject = JSONObject.parseObject(json);
            // 校验发送方是否合法
            if (!jsonObject.isEmpty()){
                String username = null;
                String password = null;
                if (jsonObject.containsKey("user")){
                    username = jsonObject.get("user").toString();
                }
                if (jsonObject.containsKey("password")){
                    password = jsonObject.get("password").toString();
                }
                boolean bl = iUserService.isAuth(username,password);
                if (!bl){
                    returnMap.put("status",fail);
                    returnMap.put("msg",userFail);
                    return returnMap;
                }
                //解析JSON数据
                if(jsonObject.containsKey("record")){
                    JSONObject record = jsonObject.getJSONObject("record");
                    //获取业务数据数组
                    JSONArray data = record.getJSONArray("data");
                    //数据将要存储的表名
                    String tableName = record.getString("tableName");
                    //计算整体JSON的md5值作为primary key
                    String md5Pk = MD5Util.MD5(json);
                }else {
                    returnMap.put("status",fail);
                    returnMap.put("msg",jsonFail);
                    return returnMap;
                }
                //向 kafka 发送消息
                System.out.println(json);
                Map<String,Object> result = iKafkaProducerServer.sendMesForTemplate(json,username);
                String msg = result.get("message").toString();
                String status = result.get("code").toString();
                if ("00000".equals(status)){
                    returnMap.put("status",success);
                    returnMap.put("msg",successMsg);
                }else{
                    returnMap.put("status",fail);
                    returnMap.put("msg",msg);
                }
            }
        }catch (JSONException jsonE){
            jsonE.printStackTrace();
            logger.error(jsonE.getMessage() + ":" + jsonE.getStackTrace());
            returnMap.put("status",fail);
            returnMap.put("msg",jsonFail);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage() + ":" + e.getStackTrace());
            returnMap.put("status",fail);
            returnMap.put("msg",failMsg);
        }
        return returnMap ;
    }
}
