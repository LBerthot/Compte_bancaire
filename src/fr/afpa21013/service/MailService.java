package fr.afpa21013.service;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import fr.afpa21013.Client;

public class MailService {
	private Session mailSession;
	private Properties emailProperties;
	public static MailService javaEmail;

	public MailService() throws MalformedURLException {

		File file = new File("./config");
		URL[] urls = { file.toURI().toURL() };
		ClassLoader loader = new URLClassLoader(urls);
		ResourceBundle bundle = ResourceBundle.getBundle("radar-config", Locale.getDefault(), loader);

		// ResourceBundle bundle = ResourceBundle.getBundle("baseName");

		this.emailProperties = System.getProperties();

		String userName = bundle.getString("mail.smtp.userName");
		String password = bundle.getString("mail.smtp.password");
		String host = bundle.getString("mail.smtp.host");
		String port = bundle.getString("mail.smtp.port");
		String isAuth = bundle.getString("mail.smtp.auth");
		String isStarttlsEnable = bundle.getString("mail.smtp.starttls.enable");

		this.emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.userName", userName);
		emailProperties.put("mail.smtp.password", password);
		emailProperties.put("mail.smtp.host", host);
		emailProperties.put("mail.smtp.port", port);
		emailProperties.put("mail.smtp.auth", isAuth);
		emailProperties.put("mail.smtp.starttls.enable", isStarttlsEnable);
		mailSession = Session.getDefaultInstance(emailProperties, null);
	}

	private MimeMessage draftEmailMessage(Client c) throws AddressException, MessagingException {

		String[] toEmails = { c.getEmail() };

		String emailSubject = "Confirmation de création de compte - Bank CDA";

		String emailBody = "Bienvenue dans notre banque " + c.getName() + " " + c.getFirstName()
				+ ".<br><br> Votre identifiant client est : <b>" + c.getIdClient()
				+ "</b>. Votre nouveau compte bancaire sera disponible sous peu.";
		MimeMessage emailMessage = new MimeMessage(mailSession);

		for (int i = 0; i < toEmails.length; i++) {
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
		}

		emailMessage.setSubject(emailSubject);
		emailMessage.setContent(emailBody, "text/html");
		return emailMessage;
	}

	public void sendEmail(Client c) throws AddressException, MessagingException {
		Transport transport = mailSession.getTransport("smtp");
		transport.connect(emailProperties.getProperty("mail.smtp.host"),
				emailProperties.getProperty("mail.smtp.userName"), emailProperties.getProperty("mail.smtp.password"));
		MimeMessage emailMessage = draftEmailMessage(c);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
		System.out.println("Notification envoyee par mail a " + c.getEmail());
	}
}