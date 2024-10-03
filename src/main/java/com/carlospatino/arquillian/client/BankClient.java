package com.carlospatino.arquillian.client;

import javax.ejb.EJB;

import com.carlospatino.arquillian.ejb.BankTransactionLocal;

public class BankClient {
	@EJB
    public BankTransactionLocal ejbTransaction;
}
