package de.sb.radio.persistence;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person extends BaseEntity {
	@NotNull @Max(1)	// do all of these get Min(1) as well?
	private Name name;
	@NotNull @Max(1)
	private Address address;
	@NotNull @Min(0) @Max(1)
	private Negotiation negotiation;
	@NotNull @Max(1)
	private Group group;
	@NotNull @NotEmpty @Size(min=1, max=128) @Email
	private String email;
	@NotNull @Size(min=64, max=64) // must be a typo right?
	private String passwordHash;
	@Min(0) @Max(1)
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
