package com.sebas.ejerciciosjpa.cap4.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRIES")
@NamedQueries({
	@NamedQuery(
			name = "Countries.findAllCountriesFromEurope",
			query = "SELECT DISTINCT r FROM Countries c JOIN c.regions r WHERE c.regions.region_id = :regionId"),
	@NamedQuery(
			name = "Countries.endWith",
			query = "SELECT c FROM Countries c WHERE c.country_name LIKE :endWith AND c.regions IN (SELECT r FROM Regions r WHERE r.region_id BETWEEN 3 AND 4) "),
	@NamedQuery(
			name = "Countries.updateSolarSystemPlanetsHowCountries",
			query = "UPDATE Countries c SET c.country_name = CONCAT(c.country_name,'_Planeta') WHERE c.regions.region_id = :solarSystemRegionId"),
	@NamedQuery(
			name = "Countries.deletePlanets",
			query = "DELETE FROM Countries c WHERE c.regions.region_id = :solarSystemRegionId"),
	@NamedQuery(
			name = "Countries.getAllPlanets",
			query = "SELECT c FROM Countries c WHERE c.regions.region_id = :solarSystemRegionId")
})
public class Countries implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1180780193864404732L;

	//definici�n de propiedades
    @Id
	@Column(name="COUNTRY_ID", length = 2)
	private String country_id;
		
	@Column(name="COUNTRY_NAME")
	private String country_name;
	
	
	@ManyToOne
	@JoinColumn(name="REGION_ID")
	private Regions regions;

	public Countries() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Countries(String country_id, String country_name, Regions region_id) {
		super();
		this.country_id = country_id;
		this.country_name = country_name;
		this.regions = region_id;
	}

	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public Regions getRegions() {
		return regions;
	}

	public void setRegions(Regions region_id) {
		this.regions = region_id;
	}

	@Override
	public String toString() {
		return "Country [id=" + country_id+ ", nombre=" + country_name + ", region_id= " + regions.getRegion_id() + "]";
	}
	
	
}

