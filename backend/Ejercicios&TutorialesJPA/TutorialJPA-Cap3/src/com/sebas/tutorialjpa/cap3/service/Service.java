package com.sebas.tutorialjpa.cap3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.sebas.tutorialjpa.cap3.entities.Bush;
import com.sebas.tutorialjpa.cap3.entities.Compatible;
import com.sebas.tutorialjpa.cap3.entities.Flora;
import com.sebas.tutorialjpa.cap3.entities.Location;
import com.sebas.tutorialjpa.cap3.entities.Plant;
import com.sebas.tutorialjpa.cap3.entities.Tree;

public class Service {

	public static void insertarLocation(EntityManager em, Location location) {
		em.persist(location);
	}

	public static void insertarFlora(EntityManager em, Flora flora) {
		em.persist(flora);
	}

	public static Location buscarLocation(EntityManager em, int id) {
		return em.find(Location.class, id);
	}

	public static Plant buscarTree(EntityManager em, int id) {
		return em.find(Tree.class, id);
	}

	public static Plant buscarBush(EntityManager em, int id) {
		return em.find(Bush.class, id);
	}

	public static Flora buscarFlora(EntityManager em, int id) {
		return em.find(Flora.class, id);
	}

	public static List<Compatible> buscarCompatibles(EntityManager em) {
		TypedQuery<Compatible> query = em.createQuery("SELECT c FROM Compatible c", Compatible.class);
		return query.getResultList();
	}

}