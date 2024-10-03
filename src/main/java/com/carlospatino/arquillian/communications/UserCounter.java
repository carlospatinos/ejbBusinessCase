package com.carlospatino.arquillian.communications;

import javax.ejb.EJB;
import javax.inject.Inject;

public class UserCounter implements GeneralCounter {

//	@EJB
//	@Inject
	private CounterService counterService;
	
	public UserCounter() {
	}
	
	@Inject
	public UserCounter(final CounterService prov) {
		this.counterService = prov;
	}
	
	@Override
	public void add(final String message) {
		counterService.add(message);
	}

	@Override
	public long getTotal() {
		return counterService.getTotal();
	}

}
