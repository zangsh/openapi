package com.mw.service;

import java.util.Map;

/**
 *  kafka 服务类
 */
public interface IKafkaProducerServer {
    /**
     * kafka发送消息模板
     * @param topic  主题
     * @param value  messageValue
     * @param ifPartiton  是否使用分区 0是\1不是
     * @param partitionNum  分区数 如果是否使用分区为0,分区数必须大于0
     * @param role  角色:bbc app erp...
     * @return
     */
    Map<String,Object> sendMesForTemplate(Object value,String username);
    Map<String,Object> sendMesForTemplate(String topic, Object value, String ifPartition, Integer partitionNum, String role);
}
