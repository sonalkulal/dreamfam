package com.meteorite.base;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.meteorite.config.Configuration;

public class TestBase {
	
	public static RemoteWebDriver driver;
	public Configuration config;
	
	public static RemoteWebDriver getDriver() {
		return driver;
		
	}
	
	@Parameters("browser-name")
	@BeforeMethod
	public RemoteWebDriver setUp(@Optional String browserName) {
		config=new Configuration();
		if(browserName==null) {
			browserName="Chrome";
		}
		if(browserName.equalsIgnoreCase("Chrome")){
			driver=new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("Firefox")){
			driver=new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("InternetExplorer")){
			driver=new InternetExplorerDriver();
			
		}
		else {
			System.out.println("Launching default driver");
			driver=new ChromeDriver();
		}
		//driver.get(config.getAppUrl("beta"));
		return driver;
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
	
}
	
