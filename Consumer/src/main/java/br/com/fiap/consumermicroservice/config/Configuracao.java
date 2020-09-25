package br.com.fiap.consumermicroservice.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;

public class Configuracao {
    private static CachingConnectionFactory connectionFactory;

    public static CachingConnectionFactory getConnection(){

        if(connectionFactory == null){
            connectionFactory = new CachingConnectionFactory("coyote.rmq.cloudamqp.com");//TODO add hostname
            connectionFactory.setUsername("xuojrorw");//TODO add username
            connectionFactory.setPassword("8N6MH52gBGrZ9encN5qFREiEt8pIEuT5");//TODO add password
            connectionFactory.setVirtualHost("xuojrorw");//TODO add virtualhost

            //Recommended settings
            connectionFactory.setRequestedHeartBeat(30);
            connectionFactory.setConnectionTimeout(30000);
        }

        return connectionFactory;
    }
}
