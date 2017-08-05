package kr.co.redcore.service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	@Autowired
	protected JavaMailSender mailSender;

	public void sendEmail(String receiver, String subject, String content) throws Exception {
		MimeMessage msg = mailSender.createMimeMessage();

		try {
			msg.setSubject(subject);
			msg.setText(content);
			msg.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(receiver));
		} catch (MessagingException ex) {
			throw ex;
		}

		try {
			mailSender.send(msg);
		} catch (MailException ex) {
			throw ex;
		}
	}
}