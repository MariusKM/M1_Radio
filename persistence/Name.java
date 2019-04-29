package de.sb.radio.persistence;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Name {
	
	@Embedded
	@NotNull @NotEmpty @Size(min=1, max=31)
	private String surname;
	
	@Embedded
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
}
