package de.sb.radio.persistence;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Name {
	@NotNull @NotEmpty @Size(min=1, max=31)
	private String family;
	@NotNull @NotEmpty @Size(min=1, max=31)
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
