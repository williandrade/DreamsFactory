package com.dreamsfactory.exception;

public class ArgumentMissingException extends Exception {

	public ArgumentMissingException(String... fields) {
		super(generateMessage(fields));
	}

	private static String generateMessage(String[] fields) {
		StringBuilder message = new StringBuilder();

		message.append("The arguments: ");

		for (int i = 0; i < fields.length; i++) {
			message.append(fields[i]);
			if (i < fields.length - 1) {
				message.append(",");
			}
		}

		message.append(" are missing");
		return message.toString();
	}

}
