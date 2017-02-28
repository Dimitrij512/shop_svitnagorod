package com.shop.svitnagorod.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
	@Autowired
	private JavaMailSenderImpl mailSender;

	@Override
	public void sendMail(String mail, String text) {
		MimeMessagePreparator preparator = getMessagePreparator(mail, text);
		try {
			mailSender.send(preparator);
		} catch (MailException ex) {
			System.err.println("exeption : " + ex.getMessage());
		}

	}

	private MimeMessagePreparator getMessagePreparator(String mail, String text) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mail));
				mimeMessage.setText("Dear, thank you for placing order. Your order id is "
				    + text);
				mimeMessage.setSubject("Your order on Demoapp");
			}
		};
		return preparator;
	}

	@Override
	public void sendRegistrationMail(String mail, String name, String surname) {

		MimeMessagePreparator preparator = messageForRegistration(mail, name, surname);
		mailSender.send(preparator);

	}

	private MimeMessagePreparator messageForRegistration(String mail, String name, String surname) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mail));
				mimeMessage.setText("Дорогий " + name + " " + surname + " ми вітаємо Вам з успішною реєстрацією на нашому сайті!!!"
				    + "Дякуємо за співпрацю");
				mimeMessage.setSubject("Demoapp - реєстрація");
			}
		};
		return preparator;
	}

}
