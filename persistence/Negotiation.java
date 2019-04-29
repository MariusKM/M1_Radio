package de.sb.radio.persistence;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Negotiation {
	@NotNull @NotEmpty @Size(min=0, max=2046)
	private String offer;
	@Size(min=1, max=2046)
	private String answer;
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
