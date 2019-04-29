package de.sb.radio.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	@Column(nullable = false, updatable = false, insertable = true)
	@NotNull 
	private Document cover;
	
	@Column(nullable = false, updatable = false, insertable = true)
	@NotNull
	private Set<Track> tracks;

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
