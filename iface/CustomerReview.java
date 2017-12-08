package review.iface;

import java.util.List;

public interface CustomerReview {

	public int getRate();

	public void setRate(int rate);

	public String getReview();

	public void setReview(String review);

	public List<Exception> getExceptions();

	public void addException(Exception e);

}
