import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ProducerTestAsynchronously {
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("TestProducerGroup");
        producer.setNamesrvAddr("localhost:9876");
        try {
            producer.start();
            producer.setRetryTimesWhenSendAsyncFailed(0);
            int messageCount = 100;
            final CountDownLatch countDownLatch = new CountDownLatch(messageCount);
            for (int i = 0; i < 100; i++) {
                Message message = new Message("TopicTest", "TagA", "OrderId100", ("Hellow World MQ" + i).getBytes(StandardCharsets.UTF_8));
                int finalI = i;
                producer.send(message, new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        System.out.printf("%-10d OK %s %n", finalI, sendResult.getMsgId());
                        countDownLatch.countDown();
                    }

                    @Override
                    public void onException(Throwable e) {
                        System.out.printf("%-10d Exception %s %n", finalI, e);
                        countDownLatch.countDown();
                    }
                });
            }
            countDownLatch.await(5, TimeUnit.SECONDS);
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
