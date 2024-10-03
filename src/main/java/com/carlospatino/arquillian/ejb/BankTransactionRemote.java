package com.carlospatino.arquillian.ejb;

import javax.ejb.Remote;

@Remote
public interface BankTransactionRemote {

	boolean deposit();

	boolean transfer();

}