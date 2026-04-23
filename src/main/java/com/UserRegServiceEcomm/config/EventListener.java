package com.UserRegServiceEcomm.config;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.UserRegServiceEcomm.Service.RegistrationMailService;
import com.UserRegServiceEcomm.event.UserRegistrationEvent;

@Component
public class EventListener {

	private final RegistrationMailService registrationMailService;
	
	public EventListener(RegistrationMailService registrationMailService1) {
		this.registrationMailService = registrationMailService1;
	}
	
	@Bean
	public Consumer<UserRegistrationEvent> userRegistrationMail(){
		return event -> {
			registrationMailService.registrationMailSend(event.getEmail());
			System.out.println("Registration conformation sent to mail : "+event.getEmail());
		};
	}
	
}
