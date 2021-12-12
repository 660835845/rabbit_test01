package fvti;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class provide02 {
    private static final String queue_name="queue1";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(queue_name,false,false,false,null);
        for (int i=1;i<50;i++) {
            String massages = "massage"+i;
            channel.basicPublish("", queue_name, null, massages.getBytes());
        }
        channel.close();
        connection.close();
        }
}
