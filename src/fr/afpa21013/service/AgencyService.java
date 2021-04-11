package fr.afpa21013.service;

import fr.afpa21013.Agency;
import fr.afpa21013.utils.Helpers;

public class AgencyService {
	private Agency agencies[];

	public AgencyService() {
		this.agencies = new Agency[0];
	}

	public Agency[] getAgencies() {
		return agencies;
	}

	public Agency createAgency() {
		System.out.println("\n-----Création d'une nouvelle agence-----\n");

		System.out.print("Entrez l'adresse de la nouvelle agence : ");
		String agencyAdress = Helpers.getScanner().nextLine();
		System.out.print("Entrez le nom de la nouvelle agence : ");
		String agencyName = Helpers.getScanner().nextLine();

		Agency agency = new Agency(agencyAdress, agencyName);
		this.agencies = Helpers.redimArray(this.getAgencies(), 1);
		this.agencies[this.agencies.length - 1] = agency;

		Helpers.clearScreen();
		System.out.println("\nVotre " + agency.toString() + " a été créée avec succès.\n");
		System.out.println("\nAppuyer sur entrer pour retourner au menu principal...");

		return agency;
	}
	
	public static void main(String[] args) {
		AgencyService agServe = new AgencyService();
		Agency agencetest = agServe.createAgency();
		Agency agencetest2 = agServe.createAgency();
		for (Agency agency : agServe.getAgencies()) {
			System.out.println(agency.toString());
		}
	}
}


