package com.sebas.tutorialjpa.cap3.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sebas.tutorialjpa.cap3.entities.Flora;
import com.sebas.tutorialjpa.cap3.entities.Location;
import com.sebas.tutorialjpa.cap3.service.Service;

public class ProgramOld {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TutorialJPA-Cap3");
		EntityManager em1 = emf.createEntityManager();
		EntityManager em2 = emf.createEntityManager();
		
		em1.getTransaction().begin();
		Location l1 = new Location();
		l1.setName("Parque natural Sierra Calderona");
		l1.setGpsCoordinates("6515, 1398");
	
		Location l2 = new Location();
		l2.setName("Parque Natural Sierras de Cazorla");
		l2.setGpsCoordinates("1843, 4915");
		
		
		Location l3 = new Location();
		l3.setName("Parque Nacional de Los Picos de Europa");
		l3.setGpsCoordinates("7337, 9318");
		
		Service.insertarLocation(em1, l1);
		Service.insertarLocation(em1, l2);
		Service.insertarLocation(em1, l3);
		
		em1.getTransaction().commit();
		em1.close();
		
		em2.getTransaction().begin();
		List<Flora> flora = new ArrayList<Flora>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(new Flora());
				add(new Flora());
				add(new Flora());
				add(new Flora());
				add(new Flora());
			}
		};
		Location l = Service.buscarLocation(em2, 1);
		flora.get(0).setType("TREE");
		flora.get(0).setPlantId(1);
		flora.get(0).setLocation(l);
		flora.get(1).setType("BUSH");
		flora.get(1).setPlantId(2);
		flora.get(1).setLocation(l);
		flora.get(2).setType("BUSH");
		flora.get(2).setPlantId(1);
		flora.get(2).setLocation(l);
		flora.get(3).setType("TREE");
		flora.get(3).setPlantId(4);
		flora.get(3).setLocation(l);
		flora.get(4).setType("TREE");
		flora.get(4).setPlantId(2);
		flora.get(4).setLocation(l);
		for (Flora f : flora) {
			Service.insertarFlora(em2, f);
		}
		em2.getTransaction().commit();
		em2.close();
//		em.close();
		emf.close();
	}
}