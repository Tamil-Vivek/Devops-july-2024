package org.tektutor;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class HelloTest {
	private Hello hello;
	private String actualResponse;
	private String expectedResponse;

	@Before
	public void initialize() {
		hello = new Hello();
	}

	@Test
	public void testSayHello() {
		expectedResponse = "Hello World v1.0.0 !";
		actualResponse   = hello.sayHello();	

		//If both expected and actual responses matches, the test case will pass otherwise it fails
		assertEquals ( expectedResponse, actualResponse );
	}

	@After
	public void cleanUp() {
		hello = null;
	}
}
