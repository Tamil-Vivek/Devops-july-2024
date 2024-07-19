package org.tektutor;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

public class DataAccessLayerTest {
	String actualResponse;
	String expectedResponse;
	DataAccessLayer fe;

	@Before
	public void init() {
		fe = new DataAccessLayer();	
	}

	public void testGetModuleName() {
		actualResponse   = fe.getModuleName();
		expectedResponse = "DataAccessLayer";

		assertEquals ( expectedResponse, actualResponse );
	}

	@After
	public void cleanup() {
		fe = null;	
	}
}
