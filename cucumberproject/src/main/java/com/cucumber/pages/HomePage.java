package com.cucumber.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberproject.steps.TestBase;
import com.cucumberproject.utilities.WaitFor;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(TestBase.getDriver(), this);

	}

	@FindBy(css = "html > body > div:first-of-type > header > div:first-of-type > div:nth-of-type(2) > div > form > input:first-of-type")
	WebElement searchComponent;

	@FindBy(css = "#main > ul > li:first-of-type > a:nth-of-type(2)")
	WebElement addToCartBtn;

	@FindBy(css ="h2[class*='title']")
	List<WebElement> productTitles;
	
	
	public void searchProduct(String productName) {
		searchComponent.sendKeys(productName);
		searchComponent.sendKeys(Keys.RETURN);
		System.out.println("Entered the product name" + productName + "to search");
	}

	public void clickOnAddToCartBtn(String productName) {
		searchComponent.sendKeys(productName);
		searchComponent.sendKeys(Keys.RETURN);
		addToCartBtn.click();

	}

	public List<String> getProductTitles() {
		List<String> titles = new ArrayList<String>();
		for (WebElement productTitle : productTitles) {
			String text = null;
			try {
				text = productTitle.getText();
			} catch (StaleElementReferenceException e) {
				WaitFor.staleElement(productTitle);
				text = productTitle.getText();
			}
			titles.add(text);
		}
		return titles;
	}
	
}
