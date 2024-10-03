package com.carlospatino.arquillian.communications;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserInformationSenderTest {
	
	@InjectMocks
	private UserInformationSender sender;
	
	@Spy 
	private ConsoleSenderProvider provider;

	@BeforeEach
    void setUp() {
		sender = new UserInformationSender(provider);
    }
	
	@Test
	public void testSend() throws Exception {
		String message = "Test Message";
		sender.send(message);
		verify(provider).send(message);
	}
}