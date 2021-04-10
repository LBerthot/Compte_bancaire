package fr.afpa21013.service;

import java.util.Date;

import fr.afopa21013.utils.Helpers;
import fr.afpa21013.BankAccount;
import fr.afpa21013.Client;

public class ClientService {
	private Client[] clients;

	public ClientService() {
		// empty array to start
		this.client = new Client[0];
	}
	
	public Client createClient() {
		System.out.println("\n-----Création d'un client -----\n");

		System.out.print("Nom du client : ");
		String name = Helpers.getScanner().nextLine();
		System.out.print("Prénom du client : ");
		String firstname = Helpers.getScanner().nextLine();
		System.out.print("date de naissance : ");
		Date  birthDate = Helpers.testDateValid(Helpers.getScanner().nextLine());
		System.out.print("adresse : ");
		String adress = Helpers.getScanner().nextLine();
		System.out.print("email : ");
		String email = Helpers.getScanner().nextLine();
		System.out.print("telephone : ");
		String telephon = Helpers.getScanner().nextLine();
		Client client = new Client();
		

		Helpers.clearScreen();
		System.out.println("\nVotre " + client.toString()	+ " a été créée avec succès.\n");
		System.out.println("\nAppuyer sur entrer pour retourner au menu principal...");
		clients = Helpers.redimArray(clients, 1);
		clients[clients.length-1] = client;
		return client;
	}
	
	public void searchClient(String nameNrCount) {
		//voir retour
	}
	public void searchClient(int clientId) {
		//voir retour
	}
	
	public BankAccount[] pullClientAccount(Client client) {
		//creer obj count
		// ts tableau récupérer les comptes du client (idclient)
		//stocker ds un tableau
		return null;
	}
	public void displayClientCountList(Client client) {//client ou id
		//appel de pullClientAccount
		//afficher
	}

	public void printClientInfo(Client client) {
		//appel de pullClientAccount
		//impression dans un fichier
	}
}
