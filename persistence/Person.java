package de.sb.radio.persistence;

import javax.persistence.Column;

public class Person extends BaseEntity {

	static public enum Group {
		USER, ADMIN
	};
	
	public class Name {
		char[] family = new char[31];;
		char[] given = new char[31];;

	}
	
	public class Address {
		char[] street = new char[63];;
		char[] postcode = new char[15];;
		char[] city = new char[64];

	}
    
	static Group myGroup;
	@Column(nullable = true, updatable = true)
	char[] email = new char[128];
	char[] passwordHash = new char[64];
	@Column(nullable = true, updatable = true)
	Document avatar = null;
    static Name myName;


	public Group getGroup() {
		return this.myGroup;
	}
	
	public Name getName() {
		return this.myName;
			
	}
}
