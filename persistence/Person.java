package de.sb.radio.persistence;

public class Person {
	private String email;
	private String passwordHash;
	private Document avatar;
	
	public Name getName() {
		return null;
	}
	
	public Group getGroup() {
		return null;
	}
	
	public class Name {
		private String family;
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
	
	public class Address {
		private String street;
		private String postcode;
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
	
	public enum Group {
		ADMIN,
		USER,
	}
}
