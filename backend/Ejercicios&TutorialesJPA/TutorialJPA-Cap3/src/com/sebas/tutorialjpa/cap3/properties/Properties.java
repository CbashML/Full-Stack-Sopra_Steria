package com.sebas.tutorialjpa.cap3.properties;

import javax.persistence.Access;
import javax.persistence.Embeddable;
import javax.persistence.AccessType;

@Embeddable
@Access(AccessType.FIELD)
public class Properties {
	private Leaf leafType;
	private Habitat habitat;

	public enum Habitat {
		TROPICAL, HUMEDO, SECO, CALIDO
	}

	public enum Leaf {
		NSNC, PERENNE, CADUCA
	}
	
	public Properties() {
	}

	@Override
	public String toString() {
		return "Leaf: " + leafType + ", Habitat: " + habitat;
	}
}