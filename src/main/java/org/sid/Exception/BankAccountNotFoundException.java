package org.sid.Exception;

public class BankAccountNotFoundException extends RuntimeException {

	public BankAccountNotFoundException(String message) {
		super(message);
	}

}
