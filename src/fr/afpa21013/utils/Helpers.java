package fr.afpa21013.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import fr.afpa21013.BankAccount;
import fr.afpa21013.Client;

public class Helpers {
	private static Scanner sc;

	static {
		sc = new Scanner(System.in);
	}
	
	@Override
	protected void finalize() throws Throwable {
		if (sc != null)
			sc.close();
	}

	public static Scanner getScanner() {
		return sc;
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
	
	// pour date boucle jk date ok
	public static Date testDateValid() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		while(true) {
			 try {
				 System.out.print("date de naissance : ");
				 String text = getScanner().nextLine();
		         date = formatter.parse(text);
		         break;

		        } catch (ParseException e) {
		            System.err.println("\ndate erronee. format: dd/mm/yyyy");
		        }
		}
		return date;
	}
	
	// array Client length 
	public static Client[] redimArray(Client[] arrA, int elementCount) {
		int tailleNouveauTableau = (arrA.length + elementCount) < 0 ? 0 : (arrA.length + elementCount);

		Client tmp[] = new Client[tailleNouveauTableau];
		int tailleRecopie = (elementCount < 0) ? (arrA.length + elementCount) : (arrA.length);

		if (tailleRecopie < 0) {
			tailleRecopie = 0;
		}

		for (int i = 0; i < tailleRecopie; i++) {
			tmp[i] = arrA[i];
		}

		arrA = tmp;
		tmp = null;
		return arrA;
	}
	// array Account length 
	public static BankAccount[] redimArray(BankAccount[] arrA, int elementCount) {
		int tailleNouveauTableau = (arrA.length + elementCount) < 0 ? 0 : (arrA.length + elementCount);
		
		BankAccount tmp[] = new BankAccount[tailleNouveauTableau];
		int tailleRecopie = (elementCount < 0) ? (arrA.length + elementCount) : (arrA.length);
		
		if (tailleRecopie < 0) {
			tailleRecopie = 0;
		}
		
		for (int i = 0; i < tailleRecopie; i++) {
			tmp[i] = arrA[i];
		}
		
		arrA = tmp;
		tmp = null;
		return arrA;
	}

}