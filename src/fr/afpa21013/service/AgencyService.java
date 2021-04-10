package fr.afpa21013.service;

import fr.afopa21013.utils.Helpers;
import fr.afpa21013.Agency;

public class AgencyService {

	private Agency agencies[];

	public Agency[] getAgencies() {
		return agencies;
	}

	public void setAgencies(Agency agencies[]) {
		this.agencies = agencies;
	}

	public static Agency createAgency() {
		System.out.println("\n-----Création d'une nouvelle agence-----\n");

		System.out.print("Entrez l'adresse de la nouvelle agence : ");
		String agencyAdress = Helpers.getScanner().nextLine();
		System.out.print("Entrez le nom de la nouvelle agence : ");
		String agencyName = Helpers.getScanner().nextLine();

		Agency agency = new Agency(agencyAdress, agencyName);

		Helpers.clearScreen();
		System.out.println("\nVotre " + agency.toString()	+ " a été créée avec succès.\n");
		System.out.println("\nAppuyer sur entrer pour retourner au menu principal...");

		return agency;
	}

	// Méthode pour test
	public static void main(String[] args) {
		Agency agencetest = createAgency();
		
	}
}
