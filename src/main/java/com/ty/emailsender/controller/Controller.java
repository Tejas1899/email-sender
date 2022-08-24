package com.ty.emailsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.emailsender.email.Email;

@RestController
public class Controller {

	@Autowired
	private Email email;
	
	@PostMapping("/sendmail")
	public void sendMail() {
		email.sendMail("Hired", "Welcome");
	}
}
