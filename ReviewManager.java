package review;

import review.iface.CustomerReview;

public class ReviewManager {
	private CustomerReview customerReview;

	public CustomerReview getCustomerReview() {
		return customerReview;
	}

	public void setCustomerReview(CustomerReview customerReview) {
		this.customerReview = customerReview;
	}

}
