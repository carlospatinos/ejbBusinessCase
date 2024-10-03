package com.carlospatino.arquillian.communications;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

//@Stateless
//@Stateful
public class StatelessCounter implements CounterService{
	private Map<String, Long> userCounter;
	private AtomicInteger counter;

	@Override
	public void add(String user) {
		userCounter.put(user, 1L);
		counter.incrementAndGet();
		System.out.println(user);
	}

	@PostConstruct
    public void initialize() {
		counter = new AtomicInteger();
		userCounter = new HashMap<>();
		System.out.println("Console initialized");
	}

	@Override
	public void remove(String user) {
		userCounter.remove(user);
		counter.decrementAndGet();
	}

	@Override
	public long getTotal() {
		return counter.get();
	}
}
