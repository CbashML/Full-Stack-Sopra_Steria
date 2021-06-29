package com.sebas.turorialjpa.cap4.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@NamedQueries({ @NamedQuery(name = "pelicula.all", query = "SELECT p FROM Pelicula p "),
		// Where
		@NamedQuery(name = "pelicula.por.genero", query = "SELECT p FROM Pelicula p WHERE p.genero =:genero"),
		@NamedQuery(name = "pelicula.por.director", query = "SELECT p FROM Pelicula p WHERE p.director.nombre =:director"),
		@NamedQuery(name = "pelicula.siglo21", query = "SELECT p FROM Pelicula p WHERE p.año > 2000"),
		@NamedQuery(name = "pelicula.between", query = "SELECT p FROM Pelicula p WHERE p.recaudacion BETWEEN 500 AND 1000"),
		@NamedQuery(name = "pelicula.genero", query = "SELECT p FROM Pelicula p WHERE p.genero LIKE '%cció_' "),
		@NamedQuery(name = "pelicula.maxrecaudacion", query = "SELECT p FROM Pelicula p WHERE p.recaudacion = (SELECT MAX(pel.recaudacion) FROM Pelicula pel)"),
		@NamedQuery(name = "pelicula.NotInUSA", query = "SELECT p FROM Pelicula p WHERE p.director.nacionalidad NOT IN ('Estadounidense') "),
		@NamedQuery(name = "pelicula.SinProductora", query = "SELECT p FROM Pelicula p WHERE p.productora IS NULL"),
		@NamedQuery(name = "pelicula.NotWB", query = "SELECT p FROM Pelicula p WHERE NOT EXISTS (SELECT prod FROM p.productora prod WHERE prod.nombre = 'Warner Bros')"),
		// Join
		@NamedQuery(name = "pelicula.join.director.where", query = "SELECT p.titulo,d.nombre FROM Pelicula p JOIN p.director d WHERE d.nombre ='Steven Spielberg' "),
		@NamedQuery(name = "pelicula.leftjoin.productora", query = "SELECT p.titulo,d.nombre FROM Pelicula p LEFT JOIN p.productora d"),
		// Group By
		@NamedQuery(name = "pelicula.groupBy.having", query = "SELECT d.nombre, COUNT(p) FROM Pelicula p LEFT JOIN p.productora d GROUP BY(d.nombre) HAVING COUNT(p)>1"),
		// Varias
		@NamedQuery(name = "pelicula.ANY", query = "SELECT p FROM Pelicula p WHERE p.recaudacion < ANY(SELECT pelic.presupuesto FROM Pelicula pelic) ORDER BY p.presupuesto DESC"),
		@NamedQuery(name = "pelicula.CASE", query = "SELECT p.titulo, "
				+ "CASE p.titulo WHEN 'Matrix' THEN 'Filosofica' " + "WHEN 'Jurassic Park' THEN 'Dinosaurios' "
				+ "ELSE p.genero " + "END FROM Pelicula p"),
		@NamedQuery(name = "pelicula.AVG", query = "SELECT AVG(p.presupuesto), AVG(p.recaudacion) FROM Pelicula p"),
		// Update
		@NamedQuery(name = "pelicula.UPD", query = "UPDATE Pelicula p SET p.titulo = 'La vida es Bella' WHERE p.id_pelicula = 6 "),
		// Delete
		@NamedQuery(name = "pelicula.DEL", query = "DELETE FROM Pelicula p WHERE p.id_pelicula = 8"),
})
@Table(name = "PELICULA")
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_PELICULA")
	private int id_pelicula;
	@Column(name = "TITULO")
	private String titulo;
	@Column(name = "AÑO")
	private int año;
	@Column(name = "GENERO")
	private String genero;
	@Column(name = "RECAUDACION")
	private double recaudacion;
	@Column(name = "PRESUPUESTO")
	private double presupuesto;
	@ManyToOne
	@JoinColumn(name = "DIRECTOR")
	private Director director;
	@ManyToOne
	@JoinColumn(name = "PRODUCTORA")
	private Productora productora;

	public Pelicula() {
	}

	public Pelicula(int id_pelicula, String titulo, int año, String genero, double recaudacion, double presupuesto,
			Director director, Productora productora) {
		super();
		this.id_pelicula = id_pelicula;
		this.titulo = titulo;
		this.año = año;
		this.genero = genero;
		this.recaudacion = recaudacion;
		this.presupuesto = presupuesto;
		this.director = director;
		this.productora = productora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(double recaudacion) {
		this.recaudacion = recaudacion;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public Productora getProductora() {
		return productora;
	}

	public void setProductora(Productora productora) {
		this.productora = productora;
	}

	public int getId_pelicula() {
		return id_pelicula;
	}

	@Override
	public boolean equals(Object elOtro) {
		if (elOtro instanceof Pelicula) {
			Pelicula l = (Pelicula) elOtro;
			return this.id_pelicula == l.id_pelicula;
		}
		return false;
	}

	@Override
	public String toString() {
		if (this.director == null && this.productora == null)
			return String.format(
					"id=%s, titulo=%s, año=%d, genero=%s, recaudacion=%.2f, presupuesto=%.2f, director =null, productora=null , ",
					this.id_pelicula, this.titulo, this.año, this.genero, this.recaudacion, this.presupuesto);
		else if (this.productora == null && this.director != null)
			return String.format(
					"id=%s, titulo=%s, año=%d, genero=%s, recaudacion=%.2f, presupuesto=%.2f, director =%s, productora=null,",
					this.id_pelicula, this.titulo, this.año, this.genero, this.recaudacion, this.presupuesto,
					this.director.toStringPelicula());
		else if (this.director == null && this.productora != null)
			return String.format(
					"id=%s, titulo=%s, año=%d, genero=%s, recaudacion=%.2f,presupuesto=%.2f, director =null, productora=%s,",
					this.id_pelicula, this.titulo, this.año, this.genero, this.recaudacion, this.presupuesto,
					this.productora.toStringPelicula());
		else
			return String.format(
					"id=%s, titulo=%s, año=%d, genero=%s, recaudacion=%.2f,presupuesto=%.2f, director =%s, productora=%s,",
					this.id_pelicula, this.titulo, this.año, this.genero, this.recaudacion, this.presupuesto,
					this.director.toStringPelicula(), this.productora.toStringPelicula());
	}

}
