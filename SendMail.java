package com.in.c2n.model;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	// public static void main(String[] args) {
	// List<String> toMailList=new ArrayList<String>();
	// toMailList.add("rasadjava@gmail.com");
	// toMailList.add("prasadbabutech@gmail.com");
	// toMailList.add("prasad.ba@hcl.com");
	// SendMail.Sendmail(toMailList, "https://localhost:8080:PrasadProject");
	// }
	//kiran modified file

	public static void Sendmail(List<String> recipientslist, String Maillink) {
		final String From = "techfortdummy@gmail.com";
		final String FromPassword = "40062299";
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(From, FromPassword);// change accordingly
			}
		});
		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(From));
			// message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			InternetAddress[] recipientsList = new InternetAddress[recipientslist.size()];
			for (int i = 0; i < recipientslist.size(); i++) {
				recipientsList[i] = new InternetAddress(recipientslist.get(i));
			}
			message.addRecipients(Message.RecipientType.TO, recipientsList);
			message.setSubject("Test Mail for In queue patients with time slots");
			message.setContent(Maillink, "text/html; charset=utf-8");
			message.saveChanges();
			// send the message
			Transport.send(message);
			System.out.println("message sent successfully...");
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
//yugandhar
}
