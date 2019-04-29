package de.sb.radio.persistence;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Address {
	
	@Embedded
	@NotNull @Size(min=0, max=63)
	private String street;
	
	@Embedded
	@NotNull @Size(min=0, max=15)
	private String postcode;
	
	@Embedded
	@NotNull @NotEmpty @Size(min=1, max=63)	// warum hier nicht auch min=0?
	private String city;

	public String getStreet() {
		return street;
	}
	
	protected void setStreet(String street) {
		this.street = street;
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	protected void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getCity() {
		return city;
	}
	
	protected void setCity(String city) {
		this.city = city;
	}
}
