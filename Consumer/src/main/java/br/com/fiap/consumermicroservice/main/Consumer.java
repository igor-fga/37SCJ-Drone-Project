package br.com.fiap.consumermicroservice.main;

import java.util.List;

import br.com.fiap.consumermicroservice.bo.ConsumerBO;
import br.com.fiap.consumermicroservice.bo.MailBO;
import br.com.fiap.consumermicroservice.dto.DroneInfoDTO;

public class Consumer {

	public static void main(String[] args) throws InterruptedException {

		while (true) {

			List<String> messages = new ConsumerBO().getMessages();

			if (messages.size() > 0) {

				for (String message : messages) {
					if (message.contains(";")) {

						DroneInfoDTO drone = new DroneInfoDTO(message);

						if (drone.IsAlertMessage()) {
							new MailBO().SendEmailTLS(drone);
							break;
						}
					}
					continue;
				}
			}

			Thread.sleep(60 * 1000);
		}
	}
}
