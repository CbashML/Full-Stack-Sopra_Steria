package com.sebas.jpa.servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.sebas.jpa.entities.Planta;

public class ServicioPlanta {

	private EntityManager em;

	public ServicioPlanta(EntityManager em) {
		this.em = em;
	}

	public Planta crearPlanta(int id, String nombre, String tipo) {
		Planta planta = new Planta(id, nombre, tipo);
		em.persist(planta);
		return planta;
	}

	public Planta buscarPlanta(int id) {
		return em.find(Planta.class, id);
	}

	public List<Planta> buscarTodasLasPlantas() {
		TypedQuery<Planta> query = em.createQuery("SELECT p FROM Planta p", Planta.class);
		return query.getResultList();
	}

	public Planta cambiarTipo(int id, String tipo) {
		Planta planta = buscarPlanta(id);
		planta.setTipo(tipo);
		em.persist(planta);
		return planta;
	}

	public boolean borrarPlanta(int id) {
		Planta planta = buscarPlanta(id);
		if (planta != null)
			try {
				em.remove(planta);
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		return false;
	}

}
