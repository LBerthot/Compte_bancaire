package fr.afpa21013.tests;

import fr.afpa21013.service.AgencyService;
import fr.afpa21013.service.BankAccountService;
import fr.afpa21013.service.ClientService;
import fr.afpa21013.utils.Helpers;

public class MethodesMenu {
	AgencyService agServe = AgencyService.getAgencyService();
	ClientService clServe = ClientService.getClientService();
	BankAccountService baServe = BankAccountService.getAccountService();

	public void start() {
		displayMenu();
		boolean run = true;
		do {
			String choice = Helpers.getScanner().nextLine();
			switch (choice.toUpperCase()) {
			case "1":
				Helpers.clearScreen();
				agServe.createAgency();
				break;

			case "2":
				Helpers.clearScreen();
				agServe.selectAgency();
				break;

			case "3":
				Helpers.clearScreen();
				clServe.createClient();
				break;

			case "4":
				Helpers.clearScreen();
				baServe.createAccount();
				break;

			case "5":
				Helpers.clearScreen();
				baServe.searchAccount();
				break;

			case "6":
				Helpers.clearScreen();
				searchClient();
				break;

			case "7":
				Helpers.clearScreen();
				// clServe.displayClientCountList(client);
				break;

			case "8":
				Helpers.clearScreen();
				// clServe.printClientInfo(client);
				break;

			case "Q":
				Helpers.clearScreen();
				run = false;
				System.out.println("Fermeture du programme");
				break;

			default:
				Helpers.clearScreen();
				displayMenu();
			}
		} while (run);
	}

	public void displayMenu() {
		System.out.println(
				"------------------------------------------------MENU DE GESTION DE LA BANQUE CDA------------------------------------------------\n");
		System.out.println("1- Créer une agence");
		System.out.println("2- Sélectionner une agence");
		System.out.println("3- Créer un client");
		System.out.println("4- Créer un compte bancaire");
		System.out.println("5- Rechercher un compte (par numéro de compte)");
		System.out.println("6- Rechercher un client...");
		System.out.println("7- Affichier la liste des commptes d'un client (par identifiant)");
		System.out.println("8- Imprimer les infos d'un client (par identifiant)");
		System.out.println("\nQ- Quitter\n");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------\n");
		System.out.print("Votre choix :");
	}

	public void searchClient() {
		displayMenuClient();
		displayMenu();
	}

	// A voir avec les methodes
	public void displayMenuClient() {
		System.out.println("Choisir selon...\n\n");
		System.out.println("1- Nom du client");
		System.out.println("2- Numero de compte");
		System.out.println("3- Identifiant client");
		System.out.println("4- Retour au menu principal");

		System.out.print("Votre choix :");

		label1: while (true) {
			switch (Helpers.getScanner().nextLine()) {
			case "1":
				Helpers.clearScreen();
				System.out.println("<Afficher selon le nom du client>");
				System.out.println("\n(Appuyer sur entrer pour retourner au menu principal)");
				Helpers.getScanner().nextLine();
				break label1;

			case "2":
				Helpers.clearScreen();
				System.out.println("<Afficher selon le numero de compte>");
				System.out.println("\n(Appuyer sur entrer pour retourner au menu principal)");
				Helpers.getScanner().nextLine();
				break label1;

			case "3":
				Helpers.clearScreen();
				System.out.println("<Afficher selon l'identifiant client>");
				System.out.println("\n(Appuyer sur entrer pour retourner au menu principal)");
				Helpers.getScanner().nextLine();
				break label1;

			case "4":
				Helpers.clearScreen();
				displayMenu();
				break label1;
			default:
				displayMenuClient();
			}
		}
	}
}
