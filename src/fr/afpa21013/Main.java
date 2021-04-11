package fr.afpa21013;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import fr.afpa21013.service.MethodesMenu;

public class Main {

	public static void main(String[] args) throws AddressException, MessagingException {

		MethodesMenu mm = new MethodesMenu();
		mm.start();

	}
}
