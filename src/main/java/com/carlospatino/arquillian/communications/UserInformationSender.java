package com.carlospatino.arquillian.communications;

import javax.inject.Inject;

public class UserInformationSender implements InformationSender {

	private final SenderProvider provider;
	private static final String GREETING = "Hola "; 
	
	public UserInformationSender() {
		provider = new ConsoleSenderProvider();
	}
	
	@Inject
	public UserInformationSender(final SenderProvider prov) {
		this.provider = prov;
	}
	
	@Override
	public void send(final String message) {
		provider.send(message);
	}

	@Override
	public String buildMessage(String message) {
		return GREETING + message;
	}

}
