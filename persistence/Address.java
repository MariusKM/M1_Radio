package de.sb.radio.persistence;


import javax.persistence.Embeddable;
import javax.persistence.Embedded;


@Embeddable

public class Address {
	
	@Embedded
	private String street;
	
	@Embedded
	private String postcode;
	
	@Embedded
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
