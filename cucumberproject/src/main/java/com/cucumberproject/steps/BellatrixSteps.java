package com.cucumberproject.steps;

import org.testng.Assert;

import com.cucumber.pages.ContactPage;
import com.cucumberproject.base.Keywords;
import com.cucumberproject.config.Configuration;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BellatrixSteps {
	
	Configuration config=new Configuration();
	ContactPage contactpage=new ContactPage();
	Keywords keyword=new Keywords();
	@Given("Application url completely launched and user is on the contact page")
	public void openAppUrl() {
		
		keyword.launchUrl(config.getAppUrl("beta"));
		contactpage.clickOnContactForm();
	}
	
	@When("User enter a name with numbers in the name field and submit the contact form")
	public void enterNameWithNumbers() throws InterruptedException {
		contactpage.FillContactForm();
		contactpage.clickOnCaptcha();
		contactpage.clickOnSubmit();
	}
	
	@Then("after submitting contact form user should see an error message indicating that Please enter valid name")
	public void verifyErrorMsgForInvalidNameFormat() throws InterruptedException {
		Thread.sleep(5000);
		String contactconfirmmsg = keyword.getText("css", "#wpforms-confirmation-3347 > p");
		Assert.assertFalse(contactconfirmmsg.contains("Thanks for contacting us! We will be in touch with you shortly."),
				"Invalid name format,Please enter valid name");

	}
	
	@When("User enter a name with special characters in the name field and submit the contact form")
	public void enterNameWithSpecialChars() throws InterruptedException {
		contactpage.FillTheContactForm();
		contactpage.clickOnCaptcha();
		contactpage.clickOnSubmit();
	}
	
	@When("user click the \"Submit\" button without filling out the form")
	public void submitEmptyContactForm() throws InterruptedException {
		
		contactpage.clickOnSubmit();
	}
	
	@Then("user should see an error message \"Please fill out all the required fields.\"")
	public void verifyErrorMsgForRequiredField() throws InterruptedException {
		Thread.sleep(5000);
		String requiredFieldErrorMsg = keyword.getText("css", "label#wpforms-3347-field_1-error");
		Assert.assertTrue(requiredFieldErrorMsg.contains("This field is required."),
				"Please fill out all the required fields.");

	}
	
	@When("user fill in the contact form information correctly")
	public void FillingcorrectInformationOnContactForm() throws InterruptedException {
		contactpage.FillContactFormCorrectly();
		contactpage.clickOnCaptcha();
		contactpage.clickOnSubmit();
	}
	
	@Then("user should see a confirmation message")
	public void verifySuceesMsgOnSubmittingForm() throws InterruptedException {
		Thread.sleep(5000);
		String contactconfirmmsg = keyword.getText("css", "#wpforms-confirmation-3347 > p");
		Assert.assertFalse(contactconfirmmsg.contains("Thanks for contacting us! We will be in touch with you shortly."),
				"Please fill all information correctly");

	}
	

}
