package com.meteorite.screenshotsetup;
import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;



public class MyListener implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		FullPageScreenShot screenshot=new FullPageScreenShot();
		try {
			screenshot.takeFullPageScreenShot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
	}

}
