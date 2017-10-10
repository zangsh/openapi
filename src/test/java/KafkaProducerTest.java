import com.mw.service.IKafkaProducerServer;
import com.mw.service.impl.KafkaProducerServerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.security.RunAs;
import java.util.Map;

/**
 * kafka 生产者测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class KafkaProducerTest extends AbstractJUnit4SpringContextTests{
    @Test
    public void test() {
        KafkaTemplate kafkaTemplate = (KafkaTemplate) getBean("KafkaTemplate");
        System.out.println(getBean("KafkaTemplate"));
        System.out.println(getContext());
        IKafkaProducerServer kafkaProducer = new KafkaProducerServerImpl();
        String topic = "test";
        String value = "test";
        String ifPartition = "1";
        Integer partitionNum = 3;
        String role = "test";//用来生成key
        for(int i = 0; i < 100; i++){
            kafkaTemplate.send(topic, Integer.toString(i+100), Integer.toString(i+100));
        }

//        Map<String,Object> res = kafkaProducer.sendMesForTemplate(topic, value, ifPartition, partitionNum, role);
        System.out.println("测试结果如下：===============");
       /* String message = (String)res.get("message");
        String code = (String)res.get("code");*/

        /*System.out.println("code:"+code);
        System.out.println("message:"+message);*/
    }

    protected ApplicationContext getContext(){
        return applicationContext;
    }

    public  Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
}
