package br.com.fiap.consumermicroservice.main;

import java.util.List;

import br.com.fiap.consumermicroservice.bo.ConsumerBO;
import br.com.fiap.consumermicroservice.bo.MailBO;

public class Consumer {

	public static void main(String[] args) throws InterruptedException {
			
		int confTemp = 20;
		int confUmi = 10;

		while (true) {
			List<String> messages = new ConsumerBO().getMessages();

			if (messages.size() > 0) {

				for (String message : messages) {
					if (message.contains(";")) {
						int temperatura = Integer.parseInt(message.split(";")[0]);
						int umidade = Integer.parseInt(message.split(";")[1]);

						if ((temperatura >= confTemp || temperatura <= 0) || (umidade <= confUmi)) {
							new MailBO().SendEmailTLS();
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
