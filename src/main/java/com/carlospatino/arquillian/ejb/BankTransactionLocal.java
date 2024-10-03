package com.carlospatino.arquillian.ejb;

import javax.ejb.Local;

@Local
public interface BankTransactionLocal {

	boolean deposit();

	boolean transfer();

}