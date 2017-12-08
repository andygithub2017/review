package review;

public class RateException extends Exception {
	
	private static final String massage = "The review rate is out of range!";

	public RateException() {
		super(massage);
	}
}
