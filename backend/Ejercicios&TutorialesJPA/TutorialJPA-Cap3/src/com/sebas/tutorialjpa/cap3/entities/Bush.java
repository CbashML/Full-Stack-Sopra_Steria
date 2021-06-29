package com.sebas.tutorialjpa.cap3.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sebas.tutorialjpa.cap3.properties.Properties;

@Entity
@Table(name = "BUSHES")
public class Bush extends Plant {
	@Id
	@Column(name = "BUSH_ID")
	private int id;
	@Column(name = "BUSH_NAME")
	private String name;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "leafType", column = @Column(name = "LEAF_ID")),
			@AttributeOverride(name = "habitat", column = @Column(name = "HABITAT_ID")) })
	private Properties properties;
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "BUSH_DESCRIPTION")
	private String description;

	public Bush() {
		
	}
	
	public Bush(int id) {
		setId(id);
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Bush [id=" + id + ", name=" + name + ", properties=" + properties + ", description=" + description
				+ "]";
	}
	
	

}
