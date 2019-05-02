package de.sb.radio.persistence;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Embeddable

public class Name implements Comparable<Name> {
	
	@Embedded
	@NotNull @NotEmpty @Size(min=1, max=31)
	private String family;
	
	
	@Embedded
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

	@Override
	public int compareTo(Name o) {
		// TODO Auto-generated method stub
		int result =  this.getFamily().compareTo(o.getFamily());
		return (result == 0)? this.getGiven().compareTo(o.getGiven()): result;
	}
	
	public int compareGivenTo(Name o) {
		// TODO Auto-generated method stub
		return this.getGiven().compareTo(o.getGiven()) ;
	}	
	
	public int compareFamilyTo(Name o) {
		// TODO Auto-generated method stub
		return this.getFamily().compareTo(o.getFamily()) ;
	}	
}
