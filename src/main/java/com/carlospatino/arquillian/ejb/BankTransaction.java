package com.carlospatino.arquillian.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;

//@Stateful
public class BankTransaction implements BankTransactionLocal, BankTransactionRemote {
//	@EJB
	public BankAccount bankAccount;
	
	public BankTransaction() {}
	
	@Inject
	public BankTransaction(BankAccount ba) {
		this.bankAccount = ba;
	}
	
	@Override
	public boolean deposit() {
		return false;
	}
	
	@Override
	public boolean transfer() {
		System.out.println("bankAccount " + bankAccount);
		return bankAccount.transfer("A", "B", new Float(10));
	}
}
