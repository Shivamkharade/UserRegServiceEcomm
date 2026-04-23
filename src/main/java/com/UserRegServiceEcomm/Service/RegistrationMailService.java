package com.UserRegServiceEcomm.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class RegistrationMailService {

	private final JavaMailSender mailSender;
	
	public RegistrationMailService(JavaMailSender mailSender1) {
		this.mailSender = mailSender1;
	}
	
	public void registrationMailSend(String to) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("Registration successfull");
		message.setText(
			    "Hi,\n\n" +
			    "Welcome to our e-commerce platform! Your registration was successful.\n\n" +
			    "You can now log in and start exploring our products.\n\n" +
			    "If you did not create this account, please contact our support team immediately.\n\n" +
			    "Happy shopping!\n" +
			    "Team E-Comm");
		mailSender.send(message);
		System.out.println("New User Registartion mail sent to : " + to);
	}
}
