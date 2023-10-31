package com.meteorite.productstore;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.meteorite.base.Keywords;
import com.meteorite.base.TestBase;
import com.meteorite.locators.On;
import com.meteorite.screenshotsetup.MyListener;

@Listeners(MyListener.class)
public class ValidateAddToCartFunctionality extends TestBase {
	@Test
	public void addToCart() {
	Keywords keyword=new Keywords();
	keyword.launchUrl("https://www.demoblaze.com/index.html");
	keyword.click("css", "#tbodyid > div:first-of-type > div > div > h4 > a");
	//keyword.click("xpath", On.ADDTOCARTBTN);
	}
	
	@Test
	public void placeOrder() throws InterruptedException{
		Keywords keyword=new Keywords();
		keyword.launchUrl("https://www.demoblaze.com/index.html");
		keyword.maximize(driver);
		keyword.click("xpath",On.CART);
		keyword.click("css", On.PLACEORDER);
		keyword.enterText("css", On.NAME,"12345");
		keyword.enterText("css", On.COUNTRY,"india");
		keyword.enterText("css", On.CITY,"Pune");
		keyword.enterText("css", On.CREDITCARD,"12345");
		keyword.enterText("css", On.MONTH,"December");
		keyword.enterText("css", On.YEAR,"2023");
		Thread.sleep(3000);
		keyword.click("xpath",On.PURCHACEBTN);
		String str=keyword.getText("xpath", "//h2[text()=\"Thank you for your purchase!\"]");
		keyword.click("xpath", On.OK);
		throw new ArrayIndexOutOfBoundsException();
		//Assert.assertTrue(str.contains("Thank you"),"Order not placed");
		
		
	}
	
	@Test
	public void ValidateNameField()
    {

		Keywords keyword=new Keywords();
		keyword.launchUrl("https://www.demoblaze.com/cart.html");
        String regex = "[A-Za-z]";
        keyword.click("css", On.PLACEORDER);
        keyword.enterText("css", On.NAME,"12345");
        String str=keyword.getText("css",On.NAME);

        

        if (str.matches("[" + regex + "]+")){
            System.out.println("Invalid character in Name field");
        }
        else{
            System.out.println("valid");
        }
       
    }

}
