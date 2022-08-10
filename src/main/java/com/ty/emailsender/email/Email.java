package com.ty.emailsender.email;

import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.ty.emailsender.file.CollectData;

@Component
public class Email {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendMail(String subject, String body) {

		CollectData collectData = new CollectData();

		ArrayList<String> list = collectData.allData();

		// System.out.println(list);

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

		try {
			mimeMessageHelper.setFrom("tejasgowda74747@gmail.com");
			for (String email : list) {
				mimeMessageHelper.setTo(email);
			}
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(body);

			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
