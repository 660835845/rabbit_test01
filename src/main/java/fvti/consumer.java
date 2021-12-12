package fvti;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class consumer {
    private static final String queue_name="simple_queue";
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = ConnectionUtil.getChannel();
        channel.queueDeclare(queue_name,false,false,false,null);
        consumer1 consumer1 = new consumer().new consumer1(channel);
        channel.basicConsume(queue_name, true, consumer1);
        channel.close();
        channel.getConnection();

    }
      class consumer1 extends DefaultConsumer{


        public consumer1(Channel channel) {
            super(channel);
        }

        @Override
        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
            System.out.println(new String(body,"utf-8"));
        }
    }
}
