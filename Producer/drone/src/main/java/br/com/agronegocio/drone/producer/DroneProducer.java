package br.com.agronegocio.drone.producer;

import java.util.Random;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agronegocio.drone.config.Config;
import br.com.agronegocio.drone.model.Drone;

@RestController
@RequestMapping(value = "/drones")
@Component
public class DroneProducer {

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(consumes = "application/json", produces = "application/json")
	public void addDados(@RequestBody Drone drone) throws InterruptedException {

		RabbitAdmin admin = new RabbitAdmin(Config.getConnection());
		Queue queueDrone = new Queue("drone.inf");

		final String exchange = "exchange.drone";

		admin.declareQueue(queueDrone);

		DirectExchange exchangeDrone = new DirectExchange(exchange);
		admin.declareExchange(exchangeDrone);

		admin.declareBinding(BindingBuilder.bind(queueDrone).to(exchangeDrone).with("inf"));

		RabbitTemplate template = new RabbitTemplate(Config.getConnection());

		System.out.println(drone.getIdDrone() + ";" + drone.getLatitude() + ";" + drone.getLongitude() + ";"
				+ drone.getTemperaturaAr() + ";" + drone.getUmidadeAr());

		template.convertAndSend(exchange, "inf", drone.getIdDrone() + ";" + drone.getLatitude() + ";"
				+ drone.getLongitude() + ";" + drone.getTemperaturaAr() + ";" + drone.getUmidadeAr());		

	}
}