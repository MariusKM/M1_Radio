package de.sb.radio.persistence;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Embeddable

public class Negotiation implements Comparable<Negotiation> {

	@Embedded
	@NotNull
	@NotEmpty
	@Size(min = 0, max = 2046)
	private String offer;

	@Embedded
	@Size(min = 1, max = 2046)
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

	@Override
	public int compareTo(Negotiation o) {
		// TODO Auto-generated method stub

		return Long.compare(this.timestamp, o.timestamp);
	}

	public int compareOffer(Negotiation o) {

		return this.offer.compareTo(o.offer);
	}
	
	public int compareAnswer(Negotiation o) {

		return this.answer.compareTo(o.answer);
	}
	
	public int compareTimeStamp(Negotiation o) {

		return Long.compare(this.timestamp, o.timestamp);
	}


}
