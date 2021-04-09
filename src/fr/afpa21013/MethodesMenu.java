package fr.afpa21013;

import java.io.IOException;
import java.util.Scanner;

public class MethodesMenu {
	private Scanner scanner = new Scanner(System.in);

	/**
	 * Clears the screen
	 */
	public static void clearScreen() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (IOException | InterruptedException ex) {
		}
	}

	public void displayMenu() {
		System.out.println(
				"------------------------------------------------MENU DE GESTION DE LA BANQUE CDA------------------------------------------------\n");
		System.out.println("1- Cr�er une agence");
		System.out.println("2- S�lectionner une agence");
		System.out.println("3- Cr�er un client");
		System.out.println("4- Cr�er un compte bancaire");
		System.out.println("5- Rechercher un compte (par num�ro de compte)");
		System.out.println("6- Rechercher un client...");
		System.out.println("7- Affichier la liste des commptes d'un client (par identifiant)");
		System.out.println("8- Imprimer les infos d'un client (par identifiant)");
		System.out.println("\nQ- Quitter\n");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------\n");
		System.out.print("Votre choix :");
	}

	public void createAgency() {

		System.out.println("\n<Menu de cr�ation d'une agence>");

		System.out.println("\n(Appuyer sur entrer pour continuer)");
		scanner.nextLine();
		clearScreen();
		System.out.println("\nVotre agence a �t� cr��e avec succ�s");
		System.out.println("\n(Appuyer sur entrer pour retourner au menu principal)");
	}

	public void SelectAgency() {

		System.out.println("\n<Liste des agence existantes>");
		System.out.println("Ici figure la liste des agences afin d'en s�lectionner une");

		System.out.println("\n(Appuyer sur entrer pour continuer)");
	}

	public void createClient() {

		System.out.println("\n<Menu de cr�ation d'un nouveau client>");

		System.out.println("\n(Appuyer sur entrer pour continuer)");
		scanner.nextLine();
		clearScreen();
		System.out.println("\nLe client a �t� cr�� avec succ�s");
		System.out.println("\n(Appuyer sur entrer pour retourner au menu principal)");
	}

	public void createAccount() {

		System.out.println("\n<Menu de cr�ation d'un nouveau compte>");
		System.out.println("\nVerification des informations donn�es et renvoi une erreur le cas �ch�ant");

		System.out.println("\n(Appuyer sur entrer pour continuer)");
		scanner.nextLine();
		clearScreen();
		System.out.println("\nLe compte du client X a �t� cr�� avec succ�s");
		System.out.println("\n(Appuyer sur entrer pour retourner au menu principal)");
	}

	public void searchAccount() {

		System.out.println("\n<Affichage d'un compte � partir de son num�ro>");

		System.out.println("\n(Appuyer sur entrer pour continuer)");
	}

	public void searchClient() {
		displayMenuClient();
		displayMenu();

	}

	public void displayMenuClient() {
		System.out.println("Choisir selon...\n\n");
		System.out.println("1- Nom du client");
		System.out.println("2- Numero de compte");
		System.out.println("3- Identifiant client");
		System.out.println("4- Retour au menu principal");

		System.out.print("Votre choix :");

		label1: while (true) {
			switch (scanner.nextLine()) {
			case "1":
				clearScreen();
				System.out.println("<Afficher selon le nom du client>");
				System.out.println("\n(Appuyer sur entrer pour retourner au menu principal)");
				scanner.nextLine();
				break label1;

			case "2":
				clearScreen();
				System.out.println("<Afficher selon le numero de compte>");
				System.out.println("\n(Appuyer sur entrer pour retourner au menu principal)");
				scanner.nextLine();
				break label1;

			case "3":
				clearScreen();
				System.out.println("<Afficher selon l'identifiant client>");
				System.out.println("\n(Appuyer sur entrer pour retourner au menu principal)");
				scanner.nextLine();
				break label1;

			case "4":
				clearScreen();
				displayMenu();
				break label1;
			default:
				displayMenuClient();
			}
		}
	}

	public void displayAccountList() {

		System.out.println("\n<Liste des comptes du client X>");
		System.out.println("\n(Appuyer sur entrer pour retourner au menu principal)");
	}

	public void printClientInfo() {

		System.out.println("\n<Affichage du r�capitulatif des des comptes du client>");
		System.out.println("\nSouhaitez-vous l'imprimer (oui/non)");

		System.out.println("\n(Simulation d'impression)");
		scanner.nextLine();
		clearScreen();
		System.out.println("\nLe chemin de l'impression se trouve � l'emplacement xxxxxx");
		System.out.println("\n(Appuyer sur entrer pour retourner au menu principal)");
	}

}
