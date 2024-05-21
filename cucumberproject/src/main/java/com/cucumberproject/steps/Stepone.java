package com.cucumberproject.steps;

import org.apache.log4j.Logger;

import com.cucumberproject.base.Keywords;
import com.cucumberproject.config.Configuration;

import io.cucumber.java.en.When;

public class Stepone {
	private static final Logger LOG = Logger.getLogger(Stepone.class);
	Configuration config = new Configuration();
	Keywords keyword = new Keywords();

	@When("open bellatrix app url")
	public void m1() {

		keyword.launchUrl(config.getAppUrl("beta"));

		LOG.info("Application is launched sucessfully");
		LOG.debug("debugging");
	}

}
