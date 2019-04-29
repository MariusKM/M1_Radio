package de.sb.radio.persistence;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;


@Embeddable

public class Name {
	
	@Embedded
	private String family;
	
	
	@Embedded
	private String given;
	
	public Name(String family, String given) {
		this.family = family;
		this.given = given;
	}
	
	public Name(Name other) {
		this.family = other.family;
		this.given = other.given;
	}
	
	public String getFamily() {
		return family;
	}
	
	public void setFamily(String family) {
		this.family = family;
	}
	
	public String getGiven() {
		return given;
	}
	
	public void setGiven(String given) {
		this.given = given;
	}	
}
