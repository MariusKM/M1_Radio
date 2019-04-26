package de.sb.radio.persistence;

public class Person extends BaseEntity {
	private String email;
	private String passwordHash;
	private Document avatar;
	
	public Person() {
		
	}
	
	public Name getName() {
		return null;
	}
	
	public Group getGroup() {
		return null;
	}
	
	public enum Group {
		ADMIN,
		USER,
	}
}
