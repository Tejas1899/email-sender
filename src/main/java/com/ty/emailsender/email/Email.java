package com.ty.emailsender.email;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ty.emailsender.file.CollectData;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Component
public class Email {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private Configuration configuration;

	public String getTemplate(String name) {

		StringWriter stringWriter = new StringWriter();
		try {
			switch (name) {
			case "Welcome": {
				configuration.getTemplate("welcome.ftl").process(null, stringWriter);
			}
				break;
			case "Appraisal": {
				configuration.getTemplate("appraisal.ftl").process(null, stringWriter);
			}
				break;
			case "Terminate": {
				configuration.getTemplate("terminate.ftl").process(null, stringWriter);
			}
				break;
			}

		} catch (TemplateNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return stringWriter.getBuffer().toString();
		}

	}

	public void sendMail(String subject, String body) {

		CollectData collectData = new CollectData();

		ArrayList<String> list = collectData.allData();

		ArrayList<String> tempList = collectData.templates();

		ModelAndView andView = new ModelAndView();

		// System.out.println(list);

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

		try {
			mimeMessageHelper.setFrom("tejasgowda74747@gmail.com");
			for (String email : list) {
				mimeMessageHelper.setTo(email);
				andView.addObject("email", email);
			}
			for (String template : tempList) {
				mimeMessageHelper.setText(getTemplate(template), true);
				andView.setViewName(getTemplate(template));
			}

			mimeMessageHelper.setSubject(subject);

			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
