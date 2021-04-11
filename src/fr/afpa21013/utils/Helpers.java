package fr.afpa21013.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import fr.afpa21013.Agency;
import fr.afpa21013.BankAccount;
import fr.afpa21013.Client;

public class Helpers {
	
	private static String[] codes= new String[0];
	
	{
		codes = new String[0];
		System.out.println("cree helper");
	}
	
	
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

	// array Agency length 
		public static Agency[] redimArray(Agency[] arrA, int elementCount) {
			int tailleNouveauTableau = (arrA.length + elementCount) < 0 ? 0 : (arrA.length + elementCount);
			
			Agency tmp[] = new Agency[tailleNouveauTableau];
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
		
		public static String[] redimArray(String[] arrA, int elementCount) {
			int tailleNouveauTableau = (arrA.length + elementCount) < 0 ? 0 : (arrA.length + elementCount);
			
			String tmp[] = new String[tailleNouveauTableau];
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
		
		
		public static String SetCode(int limit) {
			
			String numb;
			label1: while(true) {
				numb = generatnum(limit);
				if(codes.length>0) {
					for(String el: codes) {
						if(el.equals(numb)) {
							continue;
						}else {
							break label1;
						}
					}	
				}else {
					break label1;
				}
			}
			codes = redimArray(codes,1);
			codes[codes.length-1]= numb;
			return numb;
		}
		
		private static String generatnum(int num) {
			Random rn;
			int numb=0;
			rn = new Random();
			String res="";
			for(int i =0; i< num;i++) {
				numb = rn.nextInt(10);			
				res += String.valueOf(numb);
			}
			return res;
		}
}
