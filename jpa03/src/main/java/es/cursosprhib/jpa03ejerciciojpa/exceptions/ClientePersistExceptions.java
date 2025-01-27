package es.cursosprhib.jpa03ejerciciojpa.exceptions;

public class ClientePersistExceptions extends RuntimeException{

	public ClientePersistExceptions() {
		super();
	}

	public ClientePersistExceptions(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ClientePersistExceptions(String message, Throwable cause) {
		super(message, cause);
	}

	public ClientePersistExceptions(String message) {
		super(message);
	}

	public ClientePersistExceptions(Throwable cause) {
		super(cause);
	}

	
	
	
}
