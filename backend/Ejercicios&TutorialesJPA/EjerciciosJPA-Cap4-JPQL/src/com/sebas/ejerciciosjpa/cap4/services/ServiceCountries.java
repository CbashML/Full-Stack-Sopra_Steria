package com.sebas.ejerciciosjpa.cap4.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.sebas.ejerciciosjpa.cap4.entities.Countries;

public class ServiceCountries {

	@PersistenceContext(unitName = "EjerciciosJPA-Cap4-JPQL")
	protected EntityManager em;

	public ServiceCountries(EntityManager em) {
		this.em = em;
	}

	public List<Countries> findAllCountries() {
		TypedQuery<Countries> query = em.createQuery("SELECT c FROM Countries c", Countries.class);
		return query.getResultList();
	}

	public List<Object> findAllEuropeCountries(int regionId) {

		// List<Object[]> countries = new ArrayList<>();
		Query query = em.createNamedQuery("Countries.findAllCountriesFromEurope").setParameter("regionId", regionId);// .getResultList();
																														// //setParameter(3,regionId)
		return query.getResultList();
	}

	public List<Countries> getCountiresEndWithAndRegionIdBetween3To4(String string) {
		List<Countries> countries = em.createNamedQuery("Countries.endWith").setParameter("endWith", ("%"+string)).getResultList();
		return countries;
	}
	
	public void updatePlanets(){
		em.createNamedQuery("Countries.updateSolarSystemPlanetsHowCountries").setParameter("solarSystemRegionId", 5).executeUpdate();
	}
	
	public void  deletePlanets() {
		em.createNamedQuery("Countries.deletePlanets").setParameter("solarSystemRegionId", 5).executeUpdate();
	}
	
	public List<Countries> findAllPlanets(){
		List<Countries> countries = em.createNamedQuery("Countries.getAllPlanets").setParameter("solarSystemRegionId", 5).getResultList();
		return countries;
	}

}
