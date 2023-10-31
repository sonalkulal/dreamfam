package com.meteorite.base;

import io.cucumber.java.en.When;

public class Stepdefination {
	
	@When("say hello")
	public void m1() {
		System.out.println("Hello");
	}

}
