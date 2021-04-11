package fr.afpa21013.tests;

import fr.afpa21013.service.AgencyService;

public class TestLudivine {

	public static void main(String[] args) {

		AgencyService agServe = AgencyService.getAgencyService();
		agServe.createAgency();
		agServe.createAgency();
		agServe.selectAgency();
//		MethodesMenu mm = new MethodesMenu();
//		mm.start();

	}
}
