package org.tektutor;

public class Frontend {
	
	private BusinessLayer bl;

	public Frontend() {
		bl = new BusinessLayer();
	}

	public String getModuleName() {
		System.out.println ( bl.getModuleName() );
		return "Frontend";
	}
}
