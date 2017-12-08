package review.exception;

public class CurseWordseException extends Exception {
	
	private static final String massage = "The review contains curse words!";

	public CurseWordseException() {
		super(massage);
	}
}