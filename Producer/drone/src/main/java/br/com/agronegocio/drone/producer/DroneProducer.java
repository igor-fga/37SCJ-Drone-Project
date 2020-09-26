package br.com.agronegocio.drone.producer;

import java.util.Random;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import br.com.agronegocio.drone.config.Config;

public class DroneProducer {

	public static void main(String[] args) throws InterruptedException {

		// Set up queue, exchanges and bindings
		RabbitAdmin admin = new RabbitAdmin(Config.getConnection());
		Queue queueDrone = new Queue("drone.inf");

		final String exchange = "exchange.drone";

		admin.declareQueue(queueDrone);

		DirectExchange exchangeDrone = new DirectExchange(exchange);
		admin.declareExchange(exchangeDrone);

		admin.declareBinding(BindingBuilder.bind(queueDrone).to(exchangeDrone).with("inf"));

		RabbitTemplate template = new RabbitTemplate(Config.getConnection());

		Random r = new Random();
		int low = -25;
		int high = 40;
		int lowu = 0;
		int highu = 100;

		while (true) {

			int temperatura = r.nextInt(high - low) + low;
			int umidade = r.nextInt(highu - lowu) + lowu;

			System.out.println("Temperatura:" + temperatura + ";" + "umidade:" + umidade);

			template.convertAndSend(exchange, "inf", temperatura + ";" + umidade);
			
			Thread.sleep(10000);
			
		}

	}

}