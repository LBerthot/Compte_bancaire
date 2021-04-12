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
		// empty array to start
	}

	// singleton
	public static ClientService getClientService() {
		if (clientService == null) {
			clientService = new ClientService();
			clients = new Client[0];

		}
		return clientService;
	}

	public Client createClient() throws AddressException, MessagingException, MalformedURLException {
		String name, firstName;
		// boucle de test nom existe
		while (true) {
			System.out.print("Nom du client : ");
			name = Helpers.getScanner().nextLine();
			System.out.print("Pr�nom du client : ");
			firstName = Helpers.getScanner().nextLine();
			if (this.searchClient(name + firstName, "name") == null && !firstName.equals("") && !name.equals("")) {
				break;
			}
			System.out.println("Client deja cree ou champs non renseign�s correctement !\n");
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
				"\nLe client " + client.getName() + " " + client.getFirstName() + " a �t� cr��e avec succ�s.\n");
		System.out.println(
				"\nLa fonctionnalit� d'envoie de mail �tant momentan�ment indisponible, vous devez absolument noter votre identifiant client : "
						+ client.getIdClient());
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
			} // accountId
		}
		return null;
	}
//
//	listAccount = Helpers.redimArray(listAccount, 1);
//	listAccount[listAccount.length -1] = bk;

	private String ClientAccountToScreen(Client client) {
		String res = "";
		// BankAccount[] listAccount = new BankAccount[0];
//		BankAccount[] accounts = new BankAccount[0];
		// ts tableau r�cup�rer les comptes du client (idclient)
		// stocker ds un tableau

		BankAccountService bankAccountService = BankAccountService.getAccountService();
		String smiley = "";
		res = "\n---- Liste des comptes du client-----\n "
				+ "\nNum�ro de compte					Solde					\n";
		for (BankAccount bk : BankAccountService.bankAccounts) {
			if (bk.getClientCode().equals(client.getIdClient())) {
				smiley = bk.getSold() > 0 ? ":-)" : bk.getSold() == 0 ? ":-/" : ":-(";
				res += "Le compte " + bk.getAccountType() + " " + bk.getIdAccount() + "				" +
				bk.getSold() + "				" + smiley + "\n";
			}
		}
		System.out.println(res);
		return res;
	}

	public void displayClientCountList() {// client ou id
		// appel de pullClientAccount
		// afficher

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
		String res="";
		for (Client cl : clients) {
			if (cl.getIdClient().equals(client.getIdClient())) {
				res = client + "\n";
				res += ClientAccountToScreen(cl); 
			}
		}
		return res;
	}
	public void printClientInfo(String clientInfos, Client client) {
		// impression dans un fichier
		String location = "./countinfos";
		try {
			PrintWriter fichier = new PrintWriter( new FileWriter(location+"/"+client.getName()+"."+ client.getIdClient()+".txt"));
			fichier.print(clientInfos);
			fichier.close();
			System.out.println("fichier correctement cr��");
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}
}