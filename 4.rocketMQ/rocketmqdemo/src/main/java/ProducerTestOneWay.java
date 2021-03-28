import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

public class ProducerTestOneWay {
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("TestProducerGroup");
        producer.setNamesrvAddr("localhost:9876");
        try {
            producer.start();
            for (int i = 0; i < 100; i++) {
                Message message = new Message("TestTopicOneWay", "TagA", ("Hello RocketMQ" + i).getBytes(StandardCharsets.UTF_8));
                producer.sendOneway(message);
            }
            Thread.sleep(5000);
            producer.shutdown();
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        }
    }
}
