package com.sebas.turorialjpa.cap4.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.sebas.turorialjpa.cap4.entities.Pelicula;

public class ServicioPelicula {

	public static List<Pelicula> getPeliculasAll(EntityManager em) {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		peliculas = em.createNamedQuery("pelicula.all", Pelicula.class).getResultList();
		for (Pelicula pelicula : peliculas) {
			System.out.println(pelicula);
		}
		return peliculas;
	}

	public static List<Pelicula> getPeliculasGenero(EntityManager em, String genero) {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		peliculas = em.createNamedQuery("pelicula.por.genero", Pelicula.class).setParameter("genero", genero)
				.getResultList();
		return peliculas;
	}

	public static List<Pelicula> getPeliculasDirector(EntityManager em, String director) {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		peliculas = em.createNamedQuery("pelicula.por.director", Pelicula.class).setParameter("director", director)
				.getResultList();
		return peliculas;
	}

	public static List<Object[]> getPeliculasJoinDirectorWhere(EntityManager em) {
		List<Object[]> peliculas = new ArrayList<Object[]>();
		peliculas = em.createNamedQuery("pelicula.join.director.where", Object[].class).getResultList();
		return peliculas;
	}

	public static List<Object[]> getPeliculasLeftJoinProdyctora(EntityManager em) {
		List<Object[]> peliculas = new ArrayList<Object[]>();
		peliculas = em.createNamedQuery("pelicula.leftjoin.productora", Object[].class).getResultList();
		return peliculas;
	}

	public static List<Object[]> getPeliculasGroupByHaving(EntityManager em) {
		List<Object[]> peliculas = new ArrayList<Object[]>();
		peliculas = em.createNamedQuery("pelicula.groupBy.having", Object[].class).getResultList();
		return peliculas;
	}

	public static List<Object[]> getPeliculaCase(EntityManager em) {
		List<Object[]> peliculas = new ArrayList<Object[]>();
		peliculas = em.createNamedQuery("pelicula.CASE", Object[].class).getResultList();
		return peliculas;
	}

	public static List<Object[]> getPeliculaAverage(EntityManager em) {
		List<Object[]> peliculas = new ArrayList<Object[]>();
		peliculas = em.createNamedQuery("pelicula.AVG", Object[].class).getResultList();
		return peliculas;
	}

	public static void updatePelicula(EntityManager em) {
		
		em.createNamedQuery("pelicula.UPD").executeUpdate();
	}

	public static void deletePelicula(EntityManager em) {
		em.createNamedQuery("pelicula.DEL").executeUpdate();
	}

}
