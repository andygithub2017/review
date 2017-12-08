package review.impl;

import java.util.ArrayList;
import java.util.List;

import review.iface.CustomerReview;

public class CustomerReviewImpl implements CustomerReview {

	private String review;
	private int rate;
	private List<Exception> elist = new ArrayList<Exception>();;

	public String getReview() {
		return this.review;
	}

	public void setReview(String review) {
		this.review = review;

	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
		
	}
	
	public List<Exception> getExceptions() {
		return elist;
	}

	public void addException(Exception e) {
		elist.add(e);
	}

}
