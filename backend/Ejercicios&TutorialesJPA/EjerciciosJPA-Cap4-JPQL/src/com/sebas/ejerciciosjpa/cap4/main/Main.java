package com.sebas.ejerciciosjpa.cap4.main;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sebas.ejerciciosjpa.cap4.entities.Countries;
import com.sebas.ejerciciosjpa.cap4.entities.Regions;
import com.sebas.ejerciciosjpa.cap4.services.ServiceCountries;
import com.sebas.ejerciciosjpa.cap4.services.ServiceRegions;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EjerciciosJPA-Cap4-JPQL");
		EntityManager em = emf.createEntityManager();

		// findAllCountries(new ServiceCountries(em));
		// findAllRegions(new ServiceRegions(em));
		//
		// findAllEuropeCountries(new ServiceCountries(em));
		// findAllCountiresEndWithAndBetween3To4(new ServiceCountries(em), "ia");
		// findAllRegionWithMoreThan5CountriesAndRegionBetween3To4(new
		// ServiceRegions(em));
		
		// upadteSolarSystemPlanetsHowCountries(new ServiceCountries(em), em);
		
		
		findAllPlanets(new ServiceCountries(em), em);
		deleteAllPlanets(new ServiceCountries(em), em);
		deleteSolarSystem(new ServiceRegions(em), em);
		findAllPlanets(new ServiceCountries(em), em);

	}

	private static void deleteAllPlanets(ServiceCountries serviceCountries, EntityManager em) {
		System.out.println("\nsignature::deleteAllPlanets(ServiceCountries serviceCountries, EntityManager em)::");
		em.getTransaction().begin();
		serviceCountries.deletePlanets();
		em.getTransaction().commit();
	}

	private static void findAllPlanets(ServiceCountries serviceCountries, EntityManager em) {
		System.out.println("\nsignature::findAllPlanets(ServiceCountries serviceCountries, EntityManager em::");
		for (Countries c : serviceCountries.findAllPlanets()) 
			System.out.println(c);
	}

	private static void deleteSolarSystem(ServiceRegions serviceRegions, EntityManager em) {
		System.out.println("\nsignature::deleteSoalrSystem(ServiceRegions serviceRegions, EntityManager em)::");
		em.getTransaction().begin();
		serviceRegions.deleteSolarSystem();
		em.getTransaction().commit();
	}

	private static void upadteSolarSystemPlanetsHowCountries(ServiceCountries serviceCountries, EntityManager em) {
		System.out.println(
				"\nsignature::upadteSolarSystemPlanetsHowCountries(ServiceCountries serviceCountries, EntityManager em)::");
		em.getTransaction().begin();
		serviceCountries.updatePlanets();
		em.getTransaction().commit();
	}

	private static void findAllRegionWithMoreThan5CountriesAndRegionBetween3To4(ServiceRegions serviceRegions) {
		System.out.println(
				"\nsignature::findAllRegionWithMoreThan5CountriesAndRegionBetween3To4(ServiceRegions serviceRegions)::");
		List<Object[]> regions = serviceRegions.findRegionsWithMoreThan5CountriesAndBetweenRegion1To3();
		for (Object[] obj : regions)
			System.out.println(Arrays.toString(obj));
	}

	private static void findAllCountiresEndWithAndBetween3To4(ServiceCountries serviceCountries, String endWith) {
		System.out.println("\nsignature::findAllCountiresEndWith(ServiceCountries serviceCountries, String string)::");
		for (Countries c : serviceCountries.getCountiresEndWithAndRegionIdBetween3To4(endWith))
			System.out.println(c);
	}

	private static void findAllEuropeCountries(ServiceCountries serviceCountries) {
		System.out.println("\nsignature::findAllEuropeCountries(ServiceCountries serviceCountries)::");
		List<Object> EUCountries = serviceCountries.findAllEuropeCountries(1);
		for (Object c : EUCountries)
			System.out.println(c);
	}

	private static void findAllRegions(ServiceRegions serviceRegions) {
		System.out.println("\nsignature::findAllRegions(ServiceRegions serviceRegions)::");
		List<Regions> regions = serviceRegions.findAllRegions();
		for (Regions r : regions)
			System.out.println(r);
	}

	private static void findAllCountries(ServiceCountries serviceCountries) {
		System.out.println("\nsignature::findAllCountries(ServiceCountries serviceCountries)::");
		List<Countries> countries = serviceCountries.findAllCountries();
		for (Countries c : countries)
			System.out.println(c);
	}

}
