package de.sb.radio.persistence;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;


@Embeddable

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Negotiation {
	
	@Embedded
	@NotNull @NotEmpty @Size(min=0, max=2046)
	private String offer;
	
	@Embedded
	@Size(min=1, max=2046)
	private String answer;
	
	@Embedded
	@Past
	private Long timestamp;
	
	public String getOffer() {
		return offer;
	}
	
	public void setOffer(String offer) {
		this.offer = offer;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
