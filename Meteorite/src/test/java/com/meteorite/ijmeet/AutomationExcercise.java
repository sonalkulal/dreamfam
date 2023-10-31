package com.meteorite.ijmeet;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.meteorite.base.Keywords;
import com.meteorite.base.TestBase;
import com.meteorite.locators.On;
import com.meteorite.pages.ProductPage;
import com.meteorite.screenshotsetup.MyListener;
@Listeners(MyListener.class)
public class AutomationExcercise extends TestBase {
	Keywords keyword = new Keywords();

	
	@Test
	public void RegisterUser() throws InterruptedException {

		keyword.launchUrl("http://automationexercise.com");
		keyword.maximize(driver);
		keyword.click("css", On.SIGNUPSIGNIN);
		keyword.enterText("css", On.UNAME, "kirti");
		keyword.enterText("css", On.UEMAIL, "kiran11khande.d5588@gmail.com");
		keyword.click("css", On.LOGIN);

		keyword.click("css", On.GENDER);
		keyword.enterText("css", On.PASSWORD, "Raje@9850");
		keyword.selectByVisibleText("css", On.Day, "7");
		keyword.selectByVisibleText("css", On.MONTHS, "May");
		keyword.selectByVisibleText("css", On.YEARS, "1995");
		keyword.enterText("css", On.FNAME, "Kirti");
		keyword.enterText("css", On.LNAME, "Birangal");
		keyword.enterText("css", On.ADDRESS, "Hinjewadi,pune");
		keyword.selectByVisibleText("css", On.COUNTRYS, "India");
		keyword.enterText("css", On.STATE, "Maharastra");
		keyword.enterText("css", On.CITY1, "Pune");
		keyword.enterText("css", On.ZIPCODE, "411033");
		keyword.enterText("css", On.MOBNO, "9960509971");
		keyword.click("css", On.CREATEAC);
		

		Thread.sleep(3000);
		String str = keyword.getText("css", On.ACCCREATED);
		Assert.assertTrue(str.contains("ACCOUNT CREATED!"), "Account not created");
		

	}

	/*@Test
	public void DeleteAccount() {
		keyword.launchUrl("https://ijmeet.com/");
		keyword.click("css", On.DELETEACC);
		String accdelete = keyword.getText("css", On.ACCDELETE);
		Assert.assertTrue(accdelete.contains("ACCOUNT DELETED!"));
	}*/

	@Test
	public void loginWithIncorrectDetails() throws InterruptedException {
		keyword.launchUrl("http://automationexercise.com");
		keyword.maximize(driver);
		keyword.click("css", On.SIGNUPSIGNIN);
		keyword.enterText("css", On.EMAILTOLOGIN, "kirtikhande10@gmail.com");
		keyword.enterText("css", On.PASSTOLOGIN, "kirti@1234");
		keyword.click("css", On.LOGINUSER);
		String failToLogin = keyword.getText("css", On.FAILMESSAGE);
		Thread.sleep(3000);
		Assert.assertTrue(failToLogin.contains("Your email or password is incorrect!"),
				"login with incorrect email or password");

	}
	
	@Test
	public void resisterUserWithExistingEmail() throws InterruptedException {
		keyword.launchUrl("http://automationexercise.com");
		keyword.maximize(driver);
		keyword.click("css", On.SIGNUPSIGNIN);
		keyword.enterText("css", On.UNAME, "kirti");
		keyword.enterText("css", On.UEMAIL, "kiran11.d5588@gmail.com");
		keyword.click("css", On.LOGIN);
		String emailAlreadyExistMsg = keyword.getText("css", On.USERALREADYEXISTMSG);
		Thread.sleep(3000);
		Assert.assertTrue(emailAlreadyExistMsg.contains("Email Address already exist!"),
				"login with already exist email");

	}
	//using page object model
	@Test
	public void verifyResultForSearchProductWomenTops() throws InterruptedException {
		keyword.launchUrl("http://automationexercise.com");
		keyword.maximize(driver);
		ProductPage page=new PageFactory().initElements(getDriver(),ProductPage.class);
		page.seachCategoryWomen();
		List<String> productTitles=page.getProductTitles();
		for(String productTitle:productTitles) {
			Assert.assertTrue(productTitle.contains("Top"),"product title does not contain Top");
		}
		
		}

		

	
	
	@Test
	public void contactUs() throws InterruptedException {
		keyword.launchUrl("http://automationexercise.com");
		keyword.click("css", On.CONTACTUS);
		keyword.enterText("css", On.CONTACTNAME, "kirti");
		keyword.enterText("css", On.CONTACTEMAIL, "kirtikhande10@gmail.com");
		keyword.enterText("css", On.CONTACTSUBJECT, "enquiry");
		keyword.enterText("css", On.CONTACTMSG, "hello....");
		
		keyword.enterText("css", On.FILEUPLOAD, "C:\\Users\\DELL\\Desktop\\Resume\\pom\\pom.docx");
		keyword.click("css", On.CONTACTSUBMIT);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		String contactsucessmsg=keyword.getText("css", On.CONTACTSUCCESS);
		Assert.assertTrue(contactsucessmsg.contains("Success!"),
				"Your detail have not been submited succesfully");

		
		
	}

}
