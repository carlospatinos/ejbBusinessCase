package com.carlospatino.arquillian.communications;

public interface CounterService {
	public void add(String message);
	public void remove(String message);
	public long getTotal();
}
