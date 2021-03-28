import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

public class ProducerTestSynchronously {
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("TestProducerGroup");
        producer.setNamesrvAddr("localhost:9876");
        try {
            producer.start();
            for (int i = 0; i < 100; i++) {
                Message message = new Message("TestTopic","TagA",("Hello RocketMQ"+i).getBytes(StandardCharsets.UTF_8));
                SendResult send = producer.send(message);
                System.out.println(send);
            }
            producer.shutdown();
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        }
    }
}
