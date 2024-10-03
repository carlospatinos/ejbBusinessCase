package com.carlospatino.arquillian.communications;

import javax.annotation.PostConstruct;

public class ConsoleSenderProvider implements SenderProvider {

	@Override
	public void send(String message) {
		System.out.println(message);
	}

	@PostConstruct
    public void initialize() {
		System.out.println("Console initialized");
	}
}
