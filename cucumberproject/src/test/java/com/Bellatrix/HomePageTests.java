package com.Bellatrix;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cucumber.pages.HomePage;
import com.cucumberproject.steps.TestBase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageTests {
	HomePage homepage = new HomePage();

	@When("result after searching falcon")
	public void verifySearchResultsOnSearchingFalcon() {
		homepage.searchProduct("Falcon");
		List<String> productTitles = homepage.getProductTitles();
		SoftAssert softly = new SoftAssert();
		for (String productTitle : productTitles) {
			softly.assertTrue(productTitle.contains("Falcon"));
		}
		softly.assertAll();

	}

	@When("Falcon adding to cart")
	public void FalconAddToCart() {
		
		homepage.clickOnAddToCartBtn("Falcon");

	}
	
	
}


