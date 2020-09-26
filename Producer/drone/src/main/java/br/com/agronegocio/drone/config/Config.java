package br.com.agronegocio.drone.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;

public class Config {
	
	private static CachingConnectionFactory connectionFactory;

    public static CachingConnectionFactory getConnection(){

        if(connectionFactory == null){
            connectionFactory = new CachingConnectionFactory("coyote.rmq.cloudamqp.com");//TODO add hostname
            connectionFactory.setUsername("rfmtnuhj");//TODO add username
            connectionFactory.setPassword("jh-cwR1LBDUq9nDhuonK4BNWqPau1aat");//TODO add password
            connectionFactory.setVirtualHost("rfmtnuhj");//TODO add virtualhost

            //Recommended settings
            connectionFactory.setRequestedHeartBeat(30);
            connectionFactory.setConnectionTimeout(30000);
        }

        return connectionFactory;
    }

}