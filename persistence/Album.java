package de.sb.radio.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "radio", name = "Album")
@PrimaryKeyJoinColumn(name="albumIdentity")
public class Album extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int albumIdentity;
	
	@Column(nullable = false, updatable = false, insertable = true)
	@NotNull @Size(min=0,max=127)
	private String title;
	
	@Column(nullable = false, updatable = false, insertable = true)
	@NotNull @Positive
	private int releaseYear;
	
	@Column(nullable = false, updatable = false, insertable = true)
	@NotNull @PositiveOrZero
	private int trackCount;
	
	@NotNull 
	@ManyToOne
	@JoinColumn(name="documentIdentity")
	private Document cover;
	
	@NotNull
	@OneToMany(mappedBy="album")
	private Set<Track> tracks;
	
	protected Album() {
		this.title = "";
		this.releaseYear = 0;
		this.trackCount = 0;
		this.cover = new Document();
		this.tracks = Collections.emptySet();
	}
	
	
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

	protected void setTitle(String Title) {
		this.title = Title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	protected void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public int getTrackCount() {
		return trackCount;
	}
	
	protected void setTrackCount(int trackCount) {
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
