package com.sebas.ejerciciosjpa.cap4.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.sebas.ejerciciosjpa.cap4.entities.Regions;

public class ServiceRegions {
	protected EntityManager em;
	
	public ServiceRegions(EntityManager em) {
		this.em = em;
	}

	public List<Regions> findAllRegions(){
		TypedQuery<Regions> query = em.createQuery("SELECT r FROM Regions r", Regions.class);
		return query.getResultList();
	}
	
	public List<Object[]> findRegionsWithMoreThan5CountriesAndBetweenRegion1To3(){
		List<Object[]> regions = em.createNamedQuery("Regions.aggregatedQuery").getResultList();
		return regions;
	 }
	
	public void deleteSolarSystem(){
		em.createNamedQuery("Regions.deleteSolarSystem").setParameter("solarSystemRegionId", 5).executeUpdate();
	}

}
