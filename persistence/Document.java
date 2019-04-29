package de.sb.radio.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(schema = "radio", name = "Document")
@PrimaryKeyJoinColumn(name="documentIdentity")


public class Document extends BaseEntity{
	
	
	private int documentIdentity;
	
	@Column(nullable = false, updatable = true)
	private String hash;
	
	@Column(nullable = false, updatable = false, insertable = true)
	private byte[] content;
	
	@Column(nullable = false, updatable = false, insertable = true)
    private String type;
    
    
	
	//char[] hash = new char[64];
    // byte[] content = new byte[16777215];
 
}
