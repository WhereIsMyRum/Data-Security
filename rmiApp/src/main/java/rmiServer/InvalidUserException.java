package rmiServer;

public class InvalidUserException extends Exception {
	
	private String message;
	
	public InvalidUserException(String string) {
		message = string;
	}
	
	public String getMessage() {
		return message;
	}

}
