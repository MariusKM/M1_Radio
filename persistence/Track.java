package de.sb.radio.persistence;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(schema = "radio", name = "Track")
@PrimaryKeyJoinColumn(name="trackIdentity")

public class Track extends BaseEntity {
	
	
	private int trackIdentity;
	
	@Embedded
	@Size(max=127,min=1)
	private String name;
	
	@Embedded
	@Size(max=127,min=1)
	private String Artist;
	
	@Embedded
	@Size(max=31,min=1)
	private String genre;
	
	
	@Column(nullable = true, updatable = true)
	private Album album;
	
	
	@Column(nullable = true, updatable = true)
	private Person owner;
	
	
	@Column(nullable = false, updatable = true)
	private Document recording;
}


