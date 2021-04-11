package fr.afpa21013.service;

import fr.afpa21013.Agency;
import fr.afpa21013.utils.Helpers;

public class AgencyService {
	private static AgencyService agencyService;
	
	public static Agency agencies[];

	{
		System.out.println("utilisation agency service");
	}

	public AgencyService() {
		agencies = new Agency[0];
	}
	

	public static AgencyService getAgencyService() {
		if (agencyService == null) {
			agencyService = new AgencyService();
			System.out.println("creation agency service");
		}
		return agencyService;
	}

	public Agency createAgency() {
		System.out.println("\n-----Création d'une nouvelle agence-----\n");

		System.out.print("Entrez l'adresse de la nouvelle agence : ");
		String agencyAdress = Helpers.getScanner().nextLine();
		System.out.print("Entrez le nom de la nouvelle agence : ");
		String agencyName = Helpers.getScanner().nextLine();

		Agency agency = new Agency(agencyAdress, agencyName);
		agencies = Helpers.redimArray(agencies, 1);
		agencies[agencies.length - 1] = agency;

		Helpers.clearScreen();
		System.out.println("\nVotre " + agency.toString() + " a été créée avec succès.\n");
		System.out.println("\nAppuyer sur entrer pour retourner au menu principal...");
System.out.println(agency.getAgencyCode());
		return agency;
	}
	

	public String selectAgency() {
		for (Agency agency : agencies) {
			System.out.println("Agence " + agency.getAgencyName() + ": " + agency.getAgencyCode());
		}
		System.out.print("Entrez le Code de l'agence que vous souhaitez sélectionner : ");
		String agencyCode = Helpers.getScanner().nextLine();
		while (true) {
			for (Agency agency : agencies) {
				if (agency.getAgencyCode().equals(agencyCode)) {
					return agencyCode;
				}
			}
			System.out.println("Le code entré est invalide. Entrez un code agence existant :");
			agencyCode = Helpers.getScanner().nextLine();
		}		
	}
}