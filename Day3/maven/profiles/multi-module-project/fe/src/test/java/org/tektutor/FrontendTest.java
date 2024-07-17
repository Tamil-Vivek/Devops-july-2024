package org.tektutor;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

public class FrontendTest {
	String actualResponse;
	String expectedResponse;
	Frontend fe;

	@Before
	public void init() {
		fe = new Frontend();	
	}

	public void testGetModuleName() {
		actualResponse   = fe.getModuleName();
		expectedResponse = "Frontend";

		assertEquals ( expectedResponse, actualResponse );
	}

	@After
	public void cleanup() {
		fe = null;	
	}
}
