package fr.afpa21013.service;

import java.util.Date;

import fr.afpa21013.BankAccount;
import fr.afpa21013.Client;
import fr.afpa21013.utils.Helpers;

public class ClientService {
	public static Client[] clients;

	{
		clients = new Client[0];
	}
	
	public ClientService() {
		// empty array to start
		
	}
	
	public Client createClient() {
		String name,firstName; 
		System.out.println("\n-----Création d'un client -----\n");		
		//boucle de test nom existe
		while(true) {
			System.out.print("Nom du client : ");
			name = Helpers.getScanner().nextLine();
			System.out.print("Prénom du client : ");
			firstName = Helpers.getScanner().nextLine();
			if(this.searchClient(name+firstName, "name") == null) {				
				break;
			}
			name = "";
			firstName ="";
			System.out.println("Client deja cree !\n");
		}
		
		//System.out.print("date de naissance : ");
		Date  birthDate = Helpers.testDateValid();
		System.out.print("adresse : ");
		String adress = Helpers.getScanner().nextLine();
		System.out.print("email : ");
		String email = Helpers.getScanner().nextLine();
		System.out.print("telephone : ");
		String telephon = Helpers.getScanner().nextLine();
		Client client = new Client(name, firstName, adress, birthDate, email, telephon, "12345678914");
		
		clients = Helpers.redimArray(clients, 1);		
		clients[clients.length-1] = client;
		System.out.println("\nVotre " + client.toString()	+ " a été créée avec succès.\n");
		System.out.println("\nAppuyer sur entrer pour retourner au menu principal...");
		return client;
		
	}
	
	public Client searchClient(String nameNrCount, String searchBy ) {
		
		if(clients.length > 0) {
			String comp = "";
			if(searchBy.equals("name")) {				
				for(Client el: clients) {
					comp += el.getName() + el.getFirstName();
					if(comp.equals(nameNrCount)) {
						return el;
					}
				}				
			}else if(searchBy.equals("compte")) {
				
			}
		}
		return null;
	}
	
	public void searchClient(int clientId) {
		//voir retour
	}
	
	public BankAccount[] pullClientAccount(Client client) {	
	
//		BankAccount[] accounts = new BankAccount[0];
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

class test{
	public static void main(String[] args) {
		ClientService cliServe = new ClientService();
		Client c1 = cliServe.createClient();
		Client c2 = cliServe.createClient();
		
	}	

}