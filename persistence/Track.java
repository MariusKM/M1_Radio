package de.sb.radio.persistence;

import javax.persistence.Column;

public class Track extends BaseEntity {
	char[] name = new char[128];
	char[] Artist = new char[128];
	char[] genre = new char[31];
	@Column(nullable = true, updatable = true)
	private Album album; 
	@Column(nullable = true, updatable = true)
	private Person owner;
	@Column(nullable = false, updatable = true)
	private Document recording;
}
