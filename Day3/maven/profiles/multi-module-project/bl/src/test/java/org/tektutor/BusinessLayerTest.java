package org.tektutor;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

public class BusinessLayerTest {
	String actualResponse;
	String expectedResponse;
	BusinessLayer fe;

	@Before
	public void init() {
		fe = new BusinessLayer();	
	}

	public void testGetModuleName() {
		actualResponse   = fe.getModuleName();
		expectedResponse = "BusinessLayer";

		assertEquals ( expectedResponse, actualResponse );
	}

	@After
	public void cleanup() {
		fe = null;	
	}
}
