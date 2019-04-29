package de.sb.radio.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "radio", name = "Track")
@PrimaryKeyJoinColumn(name="trackIdentity")
public class Track extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int trackIdentity;
	
	@Column(nullable = false, updatable = false, insertable = true)
	@NotNull @NotEmpty @Size(min=1,max=127)
	private String name;
	
	@Column(nullable = false, updatable = false, insertable = true)
	@NotNull @NotEmpty @Size(min=1,max=127)
	private String artist;
	
	@Column(nullable = false, updatable = true)
	@NotNull @NotEmpty @Size(min=1,max=31)
	private String genre;
	
	@Embedded
	@NotNull 
	private Album album;
	
	@Embedded
	@NotNull 
	private Person owner;
	
	@Embedded
	@NotNull 
	private Document recording;

	public int getTrackIdentity() {
		return trackIdentity;
	}

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

	protected void setTrackIdentity(int trackIdentity) {
		this.trackIdentity = trackIdentity;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setArtist(String artist) {
		this.artist = artist;
	}

	protected void setGenre(String genre) {
		this.genre = genre;
	}

	protected void setAlbum(Album album) {
		this.album = album;
	}

	protected void setOwner(Person owner) {
		this.owner = owner;
	}

	protected void setRecording(Document recording) {
		this.recording = recording;
	}
	
	
}


