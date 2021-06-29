package com.JPAmanual.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.JPAmanual.entidad.Animal;
import com.JPAmanual.servicios.ServicioAnimal;

public class Programa {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("animal");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Animal Hipo = ServicioAnimal.crearAnimal(em, "Hippo", "Hippopotamus amphibius", "Mamífero", "Sabana");
		Animal encontrado = ServicioAnimal.encontrarAnimal(em, "Lion");
		System.out.println(encontrado);
		if (ServicioAnimal.borrarAnimal(em, "Sparrow"))
			System.out.println("Animal eliminado");
		else
			System.out.println("Error al eliminar");
		ServicioAnimal.modificarAnimal(em, "Hippo", "Hipopótamo", "Herbívoro", "África");
		System.out.println(ServicioAnimal.getNombres(em));
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}