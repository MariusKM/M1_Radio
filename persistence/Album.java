package de.sb.radio.persistence;

import java.util.Collections;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Column(nullable = false, updatable = true)
	@NotNull @Size(min=0,max=127)
	private String title;
	
	@Column(nullable = false, updatable = true)
	@NotNull @Positive
	private int releaseYear;
	
	@Column(nullable = false, updatable = true)
	@NotNull @PositiveOrZero
	private int trackCount;
	
	@ManyToOne(optional = true)
	@JoinColumn(name="coverReference", nullable = true, updatable = true)
	private Document cover;
	
	@NotNull
	@OneToMany(mappedBy="album", cascade = { CascadeType.REFRESH, CascadeType.REMOVE })
	private Set<Track> tracks;
	
	public Album() {
		this.tracks = Collections.emptySet();
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String Title) {
		this.title = Title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public int getTrackCount() {
		return trackCount;
	}
	
	public void setTrackCount(int trackCount) {
		this.trackCount = trackCount;	
	}
	
	public Document getCover() {
		return cover;
	}
	
	public void setCover(Document cover) {
		this.cover = cover;
	}
	
	public Set<Track> getTracks(){
		return tracks;
	}
	
	public void setTracks(Set<Track> tracks) {
	  this.tracks = tracks;
	}
}
