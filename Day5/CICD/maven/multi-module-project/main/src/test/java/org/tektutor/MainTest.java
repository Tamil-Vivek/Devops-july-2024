package org.tektutor;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

public class MainTest {
	String actualResponse;
	String expectedResponse;
	Main fe;

	@Before
	public void init() {
		fe = new Main();	
	}

	public void testGetModuleName() {
		actualResponse   = fe.getModuleName();
		expectedResponse = "Main";

		assertEquals ( expectedResponse, actualResponse );
	}

	@After
	public void cleanup() {
		fe = null;	
	}
}
