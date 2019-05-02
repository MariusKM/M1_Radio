package de.sb.radio.persistence;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(schema = "radio", name = "Album")
@PrimaryKeyJoinColumn(name="albumIdentity")


public class Album extends BaseEntity {

	
	private int albumIdentity;
	
	@Embedded
	@Size(max = 127, min = 0)
	private String title;
	
	
	@Column(nullable = true, updatable = true)
	private short releaseYear;
	
	
	@Column(nullable = true, updatable = true)
	private Byte trackCount;
	
	
	@Column(nullable = true, updatable = true)
	private Document cover;
	
	
	@Column(nullable = true, updatable = true)
	private Set<Track> tracks;
	
	public Album (String title, short releaseYear, byte TrackCount) {
		
		super();
		this.title = title;
		this.releaseYear = releaseYear;
		this.trackCount = TrackCount;
		this.tracks = new HashSet<Track>(); 
		
		
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String Title) {
		this.title = Title;
	}

	public short getReleaseYear() {
		return releaseYear;
	}

	protected void setReleaseYear(short releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public Byte getTrackCount() {
		return trackCount;
	}
	
	protected void setTrackCount(byte trackCount) {
		
		this.trackCount = trackCount;	
	}
	
	public Document getCover() {
		
		return cover;
	}
	
	protected void setCover(Document cover) {
		
		this.cover = cover;
		
	}
	
	public Set<Track> getTracks(){
		
		return tracks;
		
	}
	
	protected void setTracks(Set<Track> tracks) {
		
	  this.tracks = tracks;
		
	}
}
