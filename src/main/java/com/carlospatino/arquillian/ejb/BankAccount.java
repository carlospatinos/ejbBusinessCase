package com.carlospatino.arquillian.ejb;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;

//@Singleton
//@Startup
//@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
//@Stateless
public class BankAccount {
	private Map<String, Float> bankRecords;
	
	public BankAccount() {}
	
	@PostConstruct
	public void initializeBankRecord() {
		bankRecords = new HashMap<>();
		bankRecords.put("A", new Float(100.5));
		bankRecords.put("B", new Float(10.5));
		bankRecords.put("C", new Float(180.5));
		bankRecords.put("D", new Float(140.5));
	}
	
	public boolean transfer(String sourceAccount, String targetAccount, Float transferredAmount) {
		Float sourceAmount = bankRecords.get(sourceAccount);
		Float targetAmount = bankRecords.get(targetAccount);
		
		if (sourceAmount < transferredAmount) {
			// TODO throw exception
			return false;
		}
		bankRecords.put(sourceAccount, sourceAmount - transferredAmount);
		bankRecords.put(targetAccount, targetAmount + transferredAmount);
		return true;
	}
}
