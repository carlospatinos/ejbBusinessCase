package com.carlospatino.arquillian.communications;

public class UserInformationSender implements InformationSender {

	private final ConsoleSenderProvider provider;
	private static final String GREETING = "Hola "; 
	
	public UserInformationSender() {
		provider = new ConsoleSenderProvider();
	}
	
	public UserInformationSender(final ConsoleSenderProvider prov) {
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
