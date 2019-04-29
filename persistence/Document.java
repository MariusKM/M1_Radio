package de.sb.radio.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "radio", name = "Document")
@PrimaryKeyJoinColumn(name="documentIdentity")
public class Document extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int documentIdentity;
	
	@Column(nullable = false, updatable = true)
	@NotNull @Size(min=64, max=64)
	private String hash;
	
	@Column(nullable = false, updatable = true)
	@NotNull @NotEmpty @Size(min=1, max=63)
	private byte[] content;
	
	@Column(nullable = false, updatable = false, insertable = true)
	@NotNull @NotEmpty @Size(min=1, max=16777215)
	private String type;

	public String getHash() {
		return hash;
	}

	protected void setHash(String hash) {
		this.hash = hash;
	}

	public byte[] getContent() {
		return content;
	}

	protected void setContent(byte[] content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	protected void setType(String type) {
		this.type = type;
	}
}
