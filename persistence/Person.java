package de.sb.radio.persistence;

import java.util.Set;

public class Person extends BaseEntity {
	private Name name;	//@size
	private Address address;
	private Negotiation negotiation;
	private Group group;
	private String email;
	private String passwordHash;
	private Document avatar;
	private Set<Track> tracks;
	
	public Person() {
		// sachen initialieren
	}
	
	public Name getName() {
		return null;
	}
	
	protected void setName(Name name) {
		this.name = name;
	}
	
	public Address getAddress() {
		return address;
	}

	protected void setAddress(Address address) {
		this.address = address;
	}

	public Negotiation getNegotiation() {
		return negotiation;
	}

	protected void setNegotiation(Negotiation negotiation) {
		this.negotiation = negotiation;
	}

	public String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	public Document getAvatar() {
		return avatar;
	}

	protected void setAvatar(Document avatar) {
		this.avatar = avatar;
	}

	public Set<Track> getTracks() {
		return tracks;
	}

	protected void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}

	public Group getGroup() {
		return null;
	}
	
	protected void setGroup(Group group) {
		this.group = group;
	}
	
	public enum Group {
		ADMIN,
		USER,
	}
}
