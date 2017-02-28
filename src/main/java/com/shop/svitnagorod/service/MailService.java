package com.shop.svitnagorod.service;

public interface MailService {

	void sendMail(String mail, String text);

	void sendRegistrationMail(String mail, String name, String surname);

}
