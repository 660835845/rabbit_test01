package fvti;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class provide {
    private static final String queue_name="simple_queue";
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = ConnectionUtil.getChannel();
        channel.queueDeclare(queue_name,false,false,false,null);
        String message="provide to food";
        channel.basicPublish("",queue_name,null,message.getBytes());
        channel.close();
        channel.getConnection();


    }
}
