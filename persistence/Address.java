package de.sb.radio.persistence;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Address implements Comparable<Address> {
	
	@Column(nullable = false, updatable = true)
	@NotNull @Size(min=0, max=63)
	private String street;
	
	@Column(nullable = false, updatable = true)
	@NotNull @Size(min=0, max=15)
	private String postcode;
	
	@Column(nullable = false, updatable = true)
	@NotNull @Size(min=1, max=63)
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

	@Override
	public int compareTo(Address o) {

		int result = this.compareCityTo(o);
		result = (result == 0) ? this.comparePostCodeTo(o) : result;
		result = (result == 0) ? this.compareStreetTo(o) : result;
		return result;
	}

	public int compareStreetTo(Address o) {

		return this.getStreet().compareTo(o.getStreet());

	}

	public int comparePostCodeTo(Address o) {

		return this.getPostcode().compareTo(o.getPostcode());

	}

	public int compareCityTo(Address o) {

		return this.getCity().compareTo(o.getCity());

	}
}
