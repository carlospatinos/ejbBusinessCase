package com.carlospatino.arquillian.communications;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserCounterTest {

	@InjectMocks
	private UserCounter sender;

	@Spy
	private CounterService provider;

	@BeforeEach
	void setUp() {
		sender = new UserCounter(provider);
	}

	@Test
	public void testAdd() throws Exception {
		String message = "Test Message";
		sender.add(message);
		verify(provider).add(message);
	}
}