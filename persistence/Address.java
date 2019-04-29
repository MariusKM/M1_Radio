package de.sb.radio.persistence;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Address {
	@NotNull @NotEmpty @Size(min=0, max=63)
	private String street;
	@NotNull @NotEmpty @Size(min=0, max=15) @Positive
	private String postcode;
	@NotNull @NotEmpty @Size(min=1, max=63)
	private String city;
	
	public Address(String street, String postcode, String city) {
		super();
		this.street = street;
		this.postcode = postcode;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
}
