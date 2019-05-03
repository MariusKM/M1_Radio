package de.sb.radio.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "radio", name = "Document")
@PrimaryKeyJoinColumn(name="documentIdentity")
public class Document extends BaseEntity {
	
	@Column(nullable = false, updatable = true)
	@NotNull @Size(min=64, max=64)
	private String hash;
	
	@Column(nullable = false, updatable = true)
	@NotNull @Size(min=1, max=16777215)
	private byte[] content;
	
	@Column(nullable = false, updatable = true)
	@NotNull @Size(min=1, max=63)
	private String type;
	
	public String getHash() {
		return hash;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
		this.hash = HashTools.sha256HashText(content);
	}

	public String getType() {
		return type;
	}

	protected void setType(String type) {
		this.type = type;
	}
}
