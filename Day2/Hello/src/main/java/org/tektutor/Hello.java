package org.tektutor;

public class Hello {

	public String sayHello() {
		return "Hello World v1.0.0 !";
	}

	public static void main ( String[] args ) {
		Hello hello = new Hello();
		System.out.println ( hello.sayHello() );
	}

}
