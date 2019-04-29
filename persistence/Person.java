package de.sb.radio.persistence;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.EnumType.STRING;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "radio", name = "Person")
@PrimaryKeyJoinColumn(name="personIdentity")
public class Person extends BaseEntity {
	
	// ist das �berhaupt notwendig, trotz identity in BaseIdentity
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long personIdentity;
	
	@Embedded
	@NotNull
	private Name name;
	
	@Embedded
	@NotNull
	private Address address;
	
	@Embedded
	@Null
	private Negotiation negotiation;	// in DB columns direkt in Person, keine Referenz, warum?
	
	@Enumerated(STRING)
	@NotNull
	private Group group;
	
	@Column(nullable = false, updatable = true)		// public setter Methoden??
	@NotNull @NotEmpty @Size(min=1, max=128) @Email
	private String email;
	
	@Column(nullable = false, updatable = true)
	@NotNull @Size(min=64, max=64)
	private String passwordHash;
	
	@Embedded
	@NotNull
	private Document avatar;
	
	@Embedded
	@NotNull
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

	public void setEmail(String email) {
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
	
	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}


	// hier auch nochmal @enumerated?
	public enum Group {
		ADMIN,
		USER,
	}
}
