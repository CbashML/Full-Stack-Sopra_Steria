package com.sebas.ejerciciosjpa.cap4.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="REGIONS")
@NamedQueries({
	@NamedQuery(
			name = "Regions.aggregatedQuery",
			query = "SELECT r.region_name, COUNT(c) FROM Countries c JOIN c.regions r WHERE r.region_id BETWEEN 1 AND 3 GROUP BY r.region_name HAVING COUNT(c) > 5 ORDER BY r.region_name"),
	@NamedQuery(
			name = "Regions.deleteSolarSystem",
			query = "DELETE FROM Regions r WHERE r.region_id = :solarSystemRegionId")
})
public class Regions implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7243147980495468047L;

	//definici�n de propiedades
	@Id
	@Column(name="REGION_ID")
	private int region_id;
			
	@Column(name="REGION_NAME")
	private String region_name;
	

	@OneToMany(mappedBy = "regions")
	private List<Countries> countries = new ArrayList<Countries>();


	public Regions() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Regions(int region_id, String region_name, List<Countries> countries) {
		super();
		this.region_id = region_id;
		this.region_name = region_name;
		this.countries = countries;
	}


	public int getRegion_id() {
		return region_id;
	}


	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}


	public String getRegion_name() {
		return region_name;
	}


	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}


	public List<Countries> getCountries() {
		return countries;
	}


	public void setCountries(List<Countries> countries) {
		this.countries = countries;
	}
	
	@Override
	public String toString() {
		return "Region [id=" + region_id+ ", nombre=" + region_name + ", paises=" 
				 + getCountries() + "]";
	}
}
