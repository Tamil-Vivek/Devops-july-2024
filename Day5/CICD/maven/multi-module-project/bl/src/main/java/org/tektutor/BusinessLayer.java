package org.tektutor;

public class BusinessLayer {
	private DataAccessLayer dal;

	public BusinessLayer() {
		dal = new DataAccessLayer();
	}

	public String getModuleName() {
		System.out.println ( dal.getModuleName() );
		return "BusinessLayer";
	}
}
