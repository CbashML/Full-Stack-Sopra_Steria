package com.sebas.turorialjpa.cap4.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTORA")
public class Productora implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_PRODUCTORA")
	private int id_productora;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "PAIS")
	private String pais;
	@OneToMany(mappedBy = "productora", cascade = CascadeType.PERSIST)
	private List<Pelicula> peliculas = new ArrayList<>();

	public Productora() {
	}

	public Productora(int id, String nombre, String pais) {
		super();
		this.id_productora = id;
		this.nombre = nombre;
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public int getId_productora() {
		return id_productora;
	}

	@Override
	public boolean equals(Object laOtra) {
		if (laOtra instanceof Productora) {
			Productora p = (Productora) laOtra;
			return this.id_productora == p.id_productora;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (int) this.id_productora;
	}

	@Override
	public String toString() {
		return String.format("id=%d, nombre=%s, pais=%s", this.id_productora, this.nombre, this.pais);
	}

	public String toStringPelicula() {
		return String.format("%s", this.nombre);
	}
}
