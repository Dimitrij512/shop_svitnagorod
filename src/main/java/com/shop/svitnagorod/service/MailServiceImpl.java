package com.shop.svitnagorod.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
  @Autowired
  private MimeMessage mimeMessage;

  @Autowired
  private Environment environment;
  @Autowired
  private JavaMailSenderImpl senderImpl;

  @Override
  public void sendMail(String mail, String text) {
    try {
      MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
      messageHelper.setFrom(environment.getRequiredProperty("mail.sender.address"));
      messageHelper.setTo(mail);
      messageHelper.setText(text);
      senderImpl.send(mimeMessage);
      System.out.println("mail sender................");
    } catch (MailException e) {
      throw new RuntimeException();
    } catch (MessagingException e1) {
      throw new RuntimeException();
    }

  }

}
