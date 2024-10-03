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

import javax.annotation.Resource;
import javax.inject.Inject;

@RunWith(Arquillian.class)
public class UserInformationSenderArquillianTest {

	@Inject
	private UserInformationSender sender;

	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class).addClasses(SenderProvider.class, Greeter.class,
				UserInformationSender.class, ConsoleSenderProvider.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		System.out.println(jar.toString(true));
		return jar;
	}

	@Test
//	@Ignore
	public void should_create_message() {
		Assert.assertEquals("Hola Earthling", sender.buildMessage("Earthling"));
	}
}
