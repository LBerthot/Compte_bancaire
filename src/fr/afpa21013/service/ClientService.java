package fr.afpa21013.service;

import java.util.Date;

import fr.afpa21013.BankAccount;
import fr.afpa21013.Client;
import fr.afpa21013.utils.Helpers;

public class ClientService {

	private static ClientService clientService;

	private static Client[] clients;

	{
		// clients = new Client[0];
		System.out.println("utilisation client services");
	}

	public ClientService() {
		// empty array to start
	}

	// singleton
	public static ClientService getClientService() {
		if (clientService == null) {
			clientService = new ClientService();
			clients = new Client[0];
			System.out.println("creation client services");
		}
		return clientService;
	}

	public Client createClient() {
		String name,firstName; 	
		//boucle de test nom existe
		while(true) {
			System.out.print("Nom du client : ");
			name = Helpers.getScanner().nextLine();
			System.out.print("Prénom du client : ");
			firstName = Helpers.getScanner().nextLine();
			if (this.searchClient(name + firstName, "name") == null) {
				break;
			}
//			name = "";
//			firstName ="";
			System.out.println("Client deja cree !\n");
		}

		// System.out.print("date de naissance : ");
		Date birthDate = Helpers.testDateValid();
		System.out.print("adresse : ");
		String adress = Helpers.getScanner().nextLine();
		System.out.print("email : ");
		String email = Helpers.getScanner().nextLine();
		System.out.print("telephone : ");
		String telephon = Helpers.getScanner().nextLine();
		Client client = new Client(name, firstName, adress, birthDate, email, telephon, "12345678914");

		clients = Helpers.redimArray(clients, 1);
		clients[clients.length - 1] = client;
		System.out.println("\nVotre " + client.toString() + " a été créée avec succès.\n");
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
			} else if (searchBy.equals("id")) {
				for (Client el : clients) {
					if (el.getIdClient().equals(nameNrCount)) {
						return el;
					}
				}
			} else {
			} // accountId
		}
		return null;
	}

	public BankAccount[] pullClientAccount(Client client) {

//		BankAccount[] accounts = new BankAccount[0];
		// ts tableau récupérer les comptes du client (idclient)
		// stocker ds un tableau
		return null;
	}

	public void displayClientCountList(Client client) {// client ou id
		// appel de pullClientAccount
		// afficher
	}

	public void printClientInfo(Client client) {
		// appel de pullClientAccount
		// impression dans un fichier
	}
}