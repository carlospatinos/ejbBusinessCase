package com.carlospatino.arquillian.communications;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.carlospatino.arquillian.ejb.BankAccount;
import com.carlospatino.arquillian.ejb.BankTransaction;
import com.carlospatino.arquillian.ejb.BankTransactionLocal;

import javax.annotation.Resource;
import javax.inject.Inject;

@RunWith(Arquillian.class)
public class BankTransactionArquillianTest {
	
	@Inject
	private BankTransactionLocal transaction;

	@Deployment
	public static JavaArchive createDeployment() {
		
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class).addClasses(BankTransaction.class,
				BankAccount.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		System.out.println(jar.toString(true));
		return jar;
	}

	@Test
	public void should_deduct_and_increase() {
		Assert.assertEquals(true, transaction.transfer());
	}
}
