package com.sebas.jpa.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sebas.jpa.entities.Planta;
import com.sebas.jpa.servicios.ServicioPlanta;

public class ProgramaPlanta {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("planta");
		EntityManager em = emf.createEntityManager();
		ServicioPlanta servicioPlanta = new ServicioPlanta(em);
		
		int id = 1;
		
		em.getTransaction().begin();
		Planta planta1 = servicioPlanta.crearPlanta(id, "Planta 1", "Tipo 1");
		em.getTransaction().commit();
		System.out.println("Saved:");
		System.out.println(planta1.toString());
		
		System.out.println("Found:");
		Planta plantaId1 = servicioPlanta.buscarPlanta(id);
		System.out.println(plantaId1.toString());
		
		System.out.println("Founds:");
		List<Planta> plantas = servicioPlanta.buscarTodasLasPlantas();
		for (Planta p : plantas) 
			System.out.println(p.toString());
		
		System.out.println("Change type:");
		em.getTransaction().begin();
		Planta plantaCambiada = servicioPlanta.cambiarTipo(id, "Tipo cambiado 1");
		em.getTransaction().commit();
		System.out.println(plantaCambiada.toString());
		
		System.out.println("Remove:");
		em.getTransaction().begin();
		if (servicioPlanta.borrarPlanta(id))
			System.out.println(String.format("Plant id = %d, removed", id));
		else
			System.out.println(String.format("Plant id = %s, haven´t been removed", id));
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
