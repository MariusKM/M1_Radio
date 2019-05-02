package de.sb.radio.persistence;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Embeddable
public class Address implements Comparable<Address> {
	@NotNull
	@NotEmpty
	@Size(min = 0, max = 63)

	@Embedded
	private String street;
	@NotNull
	@NotEmpty
	@Size(min = 0, max = 15)
	@Positive

	@Embedded
	private String postcode;
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 63)

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
