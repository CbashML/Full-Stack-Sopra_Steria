package com.JPAmanual.entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Animal.nombre", query = "SELECT a.nombre FROM Animal a"), })
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String nombre;
	private String clase;
	private String habitat;

	public Animal() {
	}

	public Animal(String id, String nombre, String clase, String hábitat) {
		this.id = id;
		this.nombre = nombre;
		this.clase = clase;
		this.habitat = hábitat;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getHábitat() {
		return habitat;
	}

	public void setHabitat(String hábitat) {
		this.habitat = hábitat;
	}

	@Override
	public boolean equals(Object elOtro) {
		if (elOtro instanceof Animal) {
			Animal a = (Animal) elOtro;
			return this.id == a.id;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

	@Override
	public String toString() {
		return String.format("id=%s, nombre=%s, clase=%s, hábitat=%s", this.id, this.nombre, this.clase, this.habitat);
	}
}