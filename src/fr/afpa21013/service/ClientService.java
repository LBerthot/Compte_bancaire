package fr.afpa21013.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import fr.afpa21013.BankAccount;
import fr.afpa21013.Client;
import fr.afpa21013.utils.Helpers;

public class ClientService {

	private static ClientService clientService;

	public static Client[] clients;

	public ClientService() {
	}

	public static ClientService getClientService() {
		if (clientService == null) {
			clientService = new ClientService();
			clients = new Client[0];
		}
		return clientService;
	}

	public Client createClient() throws AddressException, MessagingException, MalformedURLException {
		String name, firstName;
		// Test if the name exist
		while (true) {
			System.out.print("Nom du client : ");
			name = Helpers.getScanner().nextLine();
			System.out.print("Prénom du client : ");
			firstName = Helpers.getScanner().nextLine();
			if (this.searchClient(name + firstName, "name") == null && !firstName.equals("") && !name.equals("")) {
				break;
			}
			System.out.println("Client déja crée ou champs non renseignés correctement !\n");
		}

		Date birthDate = Helpers.testDateValid();
		System.out.print("adresse : ");
		String adress = Helpers.getScanner().nextLine();
		System.out.print("email : ");
		String email = Helpers.getScanner().nextLine();
		System.out.print("telephone : ");
		String telephon = Helpers.getScanner().nextLine();
		Client client = new Client(name, firstName, adress, birthDate, email, telephon);
		clients = Helpers.redimArray(clients, 1);
		clients[clients.length - 1] = client;
		System.out.println(
				"\nLe client " + client.getName() + " " + client.getFirstName() + " a été créée avec succès.\n");
		System.out.println("\nAppuyer sur entrer pour retourner au menu principal...");
		return client;
	}

	public Client searchClient(String nameNrCount, String searchBy) {

		if (clients.length > 0) {
			String comp = "";
			if (searchBy.equals("name")) {
				for (Client el : clients) {
					comp += el.getName() + el.getFirstName();
					if (comp.equals(nameNrCount)) {
						return el;
					}
				}
			} else if (searchBy.equals("idCli")) {
				for (Client el : clients) {
					if (el.getIdClient().equals(nameNrCount)) {
						return el;
					}
				}
			} else {
				BankAccountService bankAccount = BankAccountService.getAccountService();
				for (Client el : clients) {
					if (el.getIdAccount().equals(nameNrCount)) {
						return el;
					}
				}
			}
		}
		return null;
	}

	private String ClientAccountToScreen(Client client) {
		String res = "";
		BankAccountService bankAccountService = BankAccountService.getAccountService();
		String smiley = "";
		res = "\n---- Liste des comptes du client-----\n "
				+ "\nNuméro de compte					Solde					\n";
		for (BankAccount bk : BankAccountService.bankAccounts) {
			if (bk.getClientCode().equals(client.getIdClient())) {
				smiley = bk.getSold() > 0 ? ":-)" : bk.getSold() == 0 ? ":-/" : ":-(";
				res += "Le compte " + bk.getAccountType() + " " + bk.getIdAccount() + "				" + bk.getSold()
						+ "				" + smiley + "\n";
			}
		}
		System.out.println(res);
		return res;
	}

	public void displayClientCountList() {
		System.out.println("---- Liste des comptes du client-----\n ");
		System.out.println("identifiant du client ?");
		String idCli = Helpers.getScanner().nextLine();
		for (Client cl : clients) {
			if (cl.getIdClient().equals(idCli)) {
				ClientAccountToScreen(cl);
			}
		}
	}

	public String dislayClientInfo(Client client) {
		String res = "";
		for (Client cl : clients) {
			if (cl.getIdClient().equals(client.getIdClient())) {
				res = client + "\n";
				res += ClientAccountToScreen(cl);
			}
		}
		return res;
	}

	public void printClientInfo(String clientInfos, Client client) {
		// Save in a .text
		String location = "./countinfos";
		try {
			PrintWriter fichier = new PrintWriter(
					new FileWriter(location + "/" + client.getName() + "." + client.getIdClient() + ".txt"));
			fichier.print(clientInfos);
			fichier.close();
			System.out.println("fichier correctement créé");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}