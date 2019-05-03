package de.sb.radio.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "radio", name = "Track")
@PrimaryKeyJoinColumn(name="trackIdentity")
public class Track extends BaseEntity {
	
	@Column(nullable = false, updatable = true)
	@NotNull @Size(min=1,max=127)
	private String name;
	
	@Column(nullable = false, updatable = true)
	@NotNull @Size(min=1,max=127)
	private String artist;
	
	@Column(nullable = false, updatable = true)
	@NotNull @Size(min=1,max=31)
	private String genre;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="albumReference", nullable = false, updatable = true)
	private Album album;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="ownerReference", nullable = false, updatable = true)
	private Person owner;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="recordingReference", nullable = false, updatable = true)
	private Document recording;

	public String getName() {
		return name;
	}

	public String getArtist() {
		return artist;
	}

	public String getGenre() {
		return genre;
	}

	public Album getAlbum() {
		return album;
	}

	public Person getOwner() {
		return owner;
	}

	public Document getRecording() {
		return recording;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public void setRecording(Document recording) {
		this.recording = recording;
	}
}


