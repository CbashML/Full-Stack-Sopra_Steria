package com.sebas.turorialjpa.cap4.main;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sebas.turorialjpa.cap4.entities.Pelicula;
import com.sebas.turorialjpa.cap4.services.ServicioPelicula;

public class Programa {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cine");
		EntityManager em = emf.createEntityManager();
		
		getPeliculas(em);
		// getPeliculasPorGenero(em);
		// getPeliculasPorDirectos(em);
		// getPeliculasJoinDirector(em);
		// getPeliculasLeftJoinProductora(em);
		// getPeliculasGroupByHavingBTOne(em);
		// getPeliculaCase(em);
		getPeliculasAverage(em);
		em.getTransaction().begin();
		ServicioPelicula.updatePelicula(em);
		ServicioPelicula.deletePelicula(em);
		em.getTransaction().commit();
		getPeliculas(em);
		em.close();
		emf.close();
	}

	private static void getPeliculasAverage(EntityManager em) {
		System.out.println("::getPeliculaAverage::");
		List<Object[]> l = ServicioPelicula.getPeliculaAverage(em);
		for (Object[] p : l)
			System.out.println(Arrays.toString(p));
	}

	private static void getPeliculaCase(EntityManager em) {
		System.out.println("::getPeliculaCase::");
		List<Object[]> l = ServicioPelicula.getPeliculaCase(em);
		for (Object[] p : l)
			System.out.println(Arrays.toString(p));
	}

	private static void getPeliculasGroupByHavingBTOne(EntityManager em) {
		System.out.println("::getPeliculasGroupByHavingBTOne::");
		List<Object[]> l = ServicioPelicula.getPeliculasGroupByHaving(em);
		for (Object[] p : l)
			System.out.println(Arrays.toString(p));
	}

	private static void getPeliculasLeftJoinProductora(EntityManager em) {
		System.out.println("::getPeliculasLeftJoinProductora::");
		List<Object[]> l = ServicioPelicula.getPeliculasLeftJoinProdyctora(em);
		for (Object[] p : l)
			System.out.println(Arrays.toString(p));
	}

	private static void getPeliculasJoinDirector(EntityManager em) {
		System.out.println("::getPeliculasJoinDirector::");
		List<Object[]> l = ServicioPelicula.getPeliculasJoinDirectorWhere(em);
		for (Object[] p : l)
			System.out.println(Arrays.toString(p));
	}

	private static void getPeliculasPorDirectos(EntityManager em) {
		System.out.println("::getPeliculasPorDirector::");
		List<Pelicula> l = ServicioPelicula.getPeliculasDirector(em, "Guy Ritchie");
		for (Pelicula p : l)
			System.out.println(p.toString());
	}

	private static void getPeliculasPorGenero(EntityManager em) {
		System.out.println("::getPeliculasPorGenero::");
		List<Pelicula> l = ServicioPelicula.getPeliculasGenero(em, "Ciencia Ficción");
		for (Pelicula p : l)
			System.out.println(p.toString());
	}

	private static void getPeliculas(EntityManager em) {
		System.out.println("::getPeliculas::");
		List<Pelicula> l = ServicioPelicula.getPeliculasAll(em);
		for (Pelicula p : l)
			System.out.println(p.toString());
	}
}