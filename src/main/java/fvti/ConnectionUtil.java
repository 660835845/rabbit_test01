package fvti;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtil {

    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory  connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("13.209.74.197");
        connectionFactory.setPort(51253);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/rabbit");
        Connection connection = connectionFactory.newConnection();
        return connection;
    }

}
