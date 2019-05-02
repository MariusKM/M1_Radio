package de.sb.radio.persistence;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Embeddable


public class Name implements Comparable<Name> {
	
	@Column(name = "surname", nullable = false, updatable = true)
	@NotNull @NotEmpty @Size(min=1, max=31)
	private String surname;
	
	@Column(name = "forename", nullable = false, updatable = true)
	@NotNull @NotEmpty @Size(min=1, max=31)
	private String forename;
	
	public String getSurname() {
		return surname;
	}
	
	protected void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getForename() {
		return forename;
	}
	
	protected void setForename(String forename) {
		this.forename = forename;
	}	
	
	@Override
	public int compareTo(Name o) {
		// TODO Auto-generated method stub
		int result =  this.getSurname().compareTo(o.getSurname());
		return (result == 0)? this.getForename().compareTo(o.getForename()): result;
	}
	
	public int compareGivenTo(Name o) {
		// TODO Auto-generated method stub
		return this.getForename().compareTo(o.getForename()) ;
	}	
	
	public int compareFamilyTo(Name o) {
		// TODO Auto-generated method stub
		return this.getSurname().compareTo(o.getSurname()) ;
	}	
}
