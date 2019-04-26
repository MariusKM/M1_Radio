package de.sb.radio.persistence;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class Track extends BaseEntity {
	@Size(max=127,min=1)
	private String name;
	@Size(max=127,min=1)
	private String Artist;
	@Size(max=31,min=1)
	private String genre;
	@Column(nullable = true, updatable = true)
	private Album album;
	@Column(nullable = true, updatable = true)
	private Person owner;
	@Column(nullable = false, updatable = true)
	private Document recording;
}


