package de.sb.radio.persistence;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Embeddable


public class Name implements Comparable<Name> {
	static private final Comparator<Name> COMPARATOR = Comparator.comparing(Name::getSurname).thenComparing(Name::getForename);
	
	@Column(nullable = false, updatable = true)
	@NotNull @Size(min=1, max=31)
	private String surname;
	
	@Column(nullable = false, updatable = true)
	@NotNull @Size(min=1, max=31)
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
	public int compareTo(Name other) {
		return COMPARATOR.compare(this, other);		// so für jedes composite
	}	
}
