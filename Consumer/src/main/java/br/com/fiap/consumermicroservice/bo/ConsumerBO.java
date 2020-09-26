package br.com.fiap.consumermicroservice.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import br.com.fiap.consumermicroservice.config.Configuracao;

public class ConsumerBO {

	public List<String> getMessages() {

		RabbitTemplate template = new RabbitTemplate(Configuracao.getConnection());
		List<String> messages = new ArrayList<>();

		while (true) {
			try {

				byte[] body = template.receive("drone.inf").getBody();
				messages.add(new String(body));

			} catch (NullPointerException ex) {
				System.out.println("fila vazia!");
				return messages;
			}
		}
	}
}
