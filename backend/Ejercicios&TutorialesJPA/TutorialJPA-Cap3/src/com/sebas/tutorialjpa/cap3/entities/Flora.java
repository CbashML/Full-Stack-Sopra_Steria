package com.sebas.tutorialjpa.cap3.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "FLORA")
public class Flora {
	@Id
	@Column(name = "FLORA_ID")
	@SequenceGenerator(name = "Gen2", sequenceName = "Seq2", allocationSize = 1)
	@GeneratedValue(generator = "Gen2")
	private int id;
	@Column(name = "FLORA_TYPE_ID")
	private int plantId;
	@Column(name = "FLORA_TYPE")
	private String type;
	@ManyToOne
	@JoinColumn(name = "LOCATED_ID")
	private Location location;
	@Transient
	private Plant plant;

	public int getId() {
		return id;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int id) {
        if (plant == null)
            this.plant = new Tree(id);
        else
            this.plant.setId(id);
    }

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	@Access(AccessType.PROPERTY)
	@Column(name = "FLORA_TYPE")
	public String getType() {
		if (plant == null)
			return "";
		return plant.getClass().getSimpleName();
	}

	public void setType(String type) {
		if (this.plant == null) {
			initPlant(type);
		} else {
			modifyPlant(type);
		}
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	// --- métodos auxiliares para cargar correctamente la Planta
	private void initPlant(String type) {
		if (type.equals("Tree"))
			this.plant = new Tree();
		if (type.equals("Bush"))
			this.plant = new Bush();
	}

	private void modifyPlant(String type) {
		if (type.equals("Tree")) {
			this.plant = new Tree(this.plant.getId());
		} else if (type.equals("Bush")) {
			this.plant = new Bush(this.plant.getId());
		} else {
			System.err.println("Tipo " + type + " no reconocido");
		}
	}

	public String resolvePlantType() {
		return getType();
	}

	@Override
	public String toString() {
		return "Flora [id=" + id + ", plantId=" + plantId + ", type=" + type + ", location=" + location + ", plant="
				+ plant + "]";
	}
	
}