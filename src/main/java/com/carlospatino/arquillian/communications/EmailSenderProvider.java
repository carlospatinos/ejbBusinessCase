package com.carlospatino.arquillian.communications;

public class EmailSenderProvider implements SenderProvider {

	@Override
	public void send(String message) {
		System.out.println(message);
	}

}
