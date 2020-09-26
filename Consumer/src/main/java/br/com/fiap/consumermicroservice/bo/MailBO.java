package br.com.fiap.consumermicroservice.bo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.fiap.consumermicroservice.dto.DroneInfoDTO;

public class MailBO {

	public void SendEmailTLS(DroneInfoDTO drone) {

		final String username = "ddronefiap@gmail.com";
		final String password = "12345@21";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ddronefiap@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ifgandrade@gmail.com"));
			message.setSubject("Alerta Drone Sensor");
			message.setText("Dados coletados que batem com o filtro:" + "\n\n ID Drone: " + drone.getId()
					+ "\n Latitude: " + drone.getLatitude() + "\n Longitude" + drone.getLongitude() + "\n Temperatura: "
					+ drone.getTemperatura() + "\n Umidade do Ar: " + drone.getUmidade());

			Transport.send(message);

			System.out.println("E-mail send!");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
