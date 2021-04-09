package fr.afpa21013;

import java.io.IOException;
import java.util.Scanner;

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
}
