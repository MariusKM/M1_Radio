package de.sb.radio.persistence;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Embeddable
public class Negotiation {
	
	@Column(name = "negotiationOffer", nullable = false, updatable = true)
	@Null @Size(min=0, max=2046)
	private String offer;
	
	@Column(name = "negotiationAnswer", nullable = false, updatable = true)
	@Null @Size(min=0, max=2046)
	private String answer;

	@Column(name = "negotiationTimestamp", nullable = false, updatable = true)
	@Null @Past
	private Long timestamp;
	
	public String getOffer() {
		return offer;
	}
	
	protected void setOffer(String offer) {
		this.offer = offer;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	protected void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	protected void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
