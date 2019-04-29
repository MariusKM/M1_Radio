package de.sb.radio.persistence;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;


@Embeddable

public class Negotiation {
	
	@Embedded
	private String offer;
	
	@Embedded
	private String answer;
	
	@Embedded
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
