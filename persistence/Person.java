package de.sb.radio.persistence;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(schema = "radio", name = "Person")
@PrimaryKeyJoinColumn(name="personIdentity")

public class Person extends BaseEntity {
	
	
	private int personIdentity;
	
	
	private Name name;	//@size
	
	@Embedded
	private Address address;
	
	@Embedded
	private Negotiation negotiation;
	
	@Column(nullable = true, updatable = true)
	private String negotiationOffer;
	
	@Column(nullable = true, updatable = true)
	private String negotiationAnswer;
	
	@Column(nullable = false, updatable = true)
	private Group groupAlias;
	
	@Column(nullable = false, updatable = true)
	private String email;
	
	@Column(nullable = false, updatable = true)
	private String passwordHash;
	
	@Embedded
	private Document avatar;
	
	@Embedded
	private Set<Track> tracks;
	
	public Person() {
		// sachen initialisieren
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
		this.groupAlias = group;
	}
	
	public enum Group {
		ADMIN,
		USER,
	}
}
