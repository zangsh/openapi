package com.mw.test;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaTest {
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.put("bootstrap.servers", "192.168.126.130:9092");
            props.put("acks", "all");
            props.put("retries", 0);
            props.put("batch.size", 16384);
            props.put("linger.ms", 1);
            props.put("buffer.memory", 33554432);
            props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

            Producer<String, String> producer = new KafkaProducer<>(props);
//            Producer producer = new KafkaProducer(props);
            for(int i = 0; i < 100; i++)
                producer.send(new ProducerRecord<String, String>("test", Integer.toString(i+1000), Integer.toString(i+1000)));

            producer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
