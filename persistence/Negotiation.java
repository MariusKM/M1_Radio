package de.sb.radio.persistence;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class Negotiation implements Comparable<Negotiation>  {
	
	@Column(nullable = true, updatable = true)
	@Size(min=0, max=2046)
	private String offer;
	
	@Column(nullable = true, updatable = true)
	@Size(min=0, max=2046)
	private String answer;

	@Column(nullable = true, updatable = true)
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
	
	// COMPARATOR, timestamp first, null comparator

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
