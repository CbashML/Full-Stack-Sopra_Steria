package com.sebas.tutorialjpa.cap3.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sebas.tutorialjpa.cap3.properties.Properties;

@Entity
@Table(name = "TREES")
public class Tree extends Plant{
	@Id
	@Column(name = "TREE_ID")
	private int id;
	@Column(name = "TREE_NAME")
	private String name;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "leafType", column = @Column(name = "LEAF_TYPE")),
			@AttributeOverride(name = "habitat", column = @Column(name = "HABITAT")) })
	private Properties properties;

	public Tree() {
		
	}
	
	public Tree(int id) {
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

	@Override
	public String toString() {
		return "Tree [id=" + id + ", name=" + name + ", properties=" + properties + "]";
	}
	
	

}