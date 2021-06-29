package com.sebas.tutorialjpa.cap3.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPATIBLES")
public class Compatible implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "COMPATIBLE_ID")
	private int id;
	@Column(name = "TREE_ID")
	private int treeId;
	@Column(name = "BUSH_ID")
	private int bushId;
	@Column(name = "COMPATIBLE_RISK")
	private int risk;
	
	public int getId() {
		return id;
	}

	public int getTreeId() {
		return treeId;
	}

	public void setTreeId(int treeId) {
		this.treeId = treeId;
	}

	public int getBushId() {
		return bushId;
	}

	public void setBushId(int bushId) {
		this.bushId = bushId;
	}

	public int getRisk() {
		return risk;
	}

	public void setRisk(int risk) {
		this.risk = risk;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Compatible ? ((Compatible) obj).getId() == this.treeId : false;
	}
}
