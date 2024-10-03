package com.carlospatino.arquillian.communications;

public interface InformationSender {
	public void send(String message);
	
	public String buildMessage(String message);
}
