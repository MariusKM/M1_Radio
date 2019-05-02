package de.sb.radio.persistence;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "radio", name = "Person")
@PrimaryKeyJoinColumn(name="personIdentity")
public class Person extends BaseEntity {
	
	// ist das �berhaupt notwendig, trotz identity in BaseIdentity
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long personIdentity;
	
	@Column(nullable = false, updatable = true)		// public setter Methoden??
	@NotNull @NotEmpty @Size(min=1, max=128) @Email
	private String email;
	
	@Column(nullable = false, updatable = true)
	@NotNull @Size(min=64, max=64)
	private String passwordHash;
	
	@Enumerated(STRING)
	@NotNull
	private Group group;
	
	@Embedded
	@NotNull
	@Valid
	private Name name;
	
	@Embedded
	@NotNull
	@Valid
	private Address address;
	
	@Embedded
	@Valid
	private Negotiation negotiation;
	
	@NotNull
	@ManyToOne private Document avatar;
	
	@NotNull
	@OneToMany(mappedBy="person")
	private Set<Track> tracks;
	
	protected Person() {
		this("", "", new Name(), new Address());
	}

	public Person(String email, String passwordHash, Name name, Address address) {
		super();
		this.email = email;
		this.passwordHash = passwordHash;
		this.group = Group.USER;
		this.name = name;
		this.address = address;
		this.avatar = new Document(); 
		this.tracks = Collections.emptySet();
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
