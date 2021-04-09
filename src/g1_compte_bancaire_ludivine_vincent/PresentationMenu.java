package g1_compte_bancaire_ludivine_vincent;

import java.io.IOException;
import java.util.Scanner;

public class PresentationMenu {

	public static void main(String[] args) {
		start();
	}

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

	public static void start() {
		Scanner sc = new Scanner(System.in);
		MethodesMenu mm = new MethodesMenu();
		mm.displayMenu();
		boolean run = true;
		do {
			String choice = sc.nextLine();
			switch (choice.toUpperCase()) {
			case "1":
				clearScreen();
				mm.createAgency();
				break;

			case "2":
				clearScreen();
				mm.SelectAgency();
				break;

			case "3":
				clearScreen();
				mm.createClient();
				break;

			case "4":
				clearScreen();
				mm.createAccount();
				break;

			case "5":
				clearScreen();
				mm.searchAccount();
				break;

			case "6":
				clearScreen();
				mm.searchClient();
				break;

			case "7":
				clearScreen();
				mm.displayAccountList();
				break;

			case "8":
				clearScreen();
				mm.printClientInfo();
				break;

			case "Q":
				clearScreen();
				run = false;
				System.out.println("Fermeture du programme");
				break;

			default:
				clearScreen();
				mm.displayMenu();
			}
		} while (run);
		sc.close();
	}

}
