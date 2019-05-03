package de.sb.radio.persistence;

import static javax.persistence.EnumType.STRING;

import java.util.Collections;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "radio", name = "Person")
@PrimaryKeyJoinColumn(name="personIdentity")
public class Person extends BaseEntity {
	static private final String DEFAULT_PASSWORD_HASH = HashTools.sha256HashText("password");

	static public enum Group {
		USER,
		ADMIN
	}
	
	@Column(nullable = false, updatable = true)
	@NotNull @Size(min=1, max=128) @Email
	private String email;
	
	@Column(nullable = false, updatable = true)
	@NotNull @Size(min=64, max=64)
	private String passwordHash;
	
	@Enumerated(STRING)
	@Column(name = "groupAlias", nullable = false, updatable = true)
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
	@AttributeOverrides({
		@AttributeOverride(name = "offer", column = @Column(name = "negotiationOffer")),
		@AttributeOverride(name = "answer", column = @Column(name = "negotiationAnswer")),
		@AttributeOverride(name = "timestamp", column = @Column(name = "negotiationTimestamp")),		
	})
	private Negotiation negotiation;
	
	// bei Relationen auf der * Seite kein NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name = "avatarReference", nullable = false, updatable = true)	//immer bei manytoone
	private Document avatar;
	
	@NotNull
	@OneToMany(mappedBy="owner", cascade = { CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH })
	private Set<Track> tracks;

	public Person() {
		super();
		this.passwordHash = DEFAULT_PASSWORD_HASH;
		this.group = Group.USER;
		this.name = new Name();
		this.address = new Address();
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

	public void setNegotiation(Negotiation negotiation) {
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

	public void setAvatar(Document avatar) {
		this.avatar = avatar;
	}

	public Set<Track> getTracks() {
		return tracks;
	}

	public Group getGroup() {
		return group;
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
}
