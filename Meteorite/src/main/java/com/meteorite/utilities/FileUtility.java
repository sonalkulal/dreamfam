package com.meteorite.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	//general method to read any property file
	public String getProperty(String filePath,String key) {
		String baseDir=System.getProperty("user.dir");
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(baseDir+filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties prop=new Properties();
		String value="";
		try {
			prop.load(fis);
			prop.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
		
	}
	public String getLocator(String locatorName) throws FileNotFoundException {
	// Read locator.properties file
		return getProperty("/src/main/resources/Locator.properties",locatorName);
	}
	
	public void loadExcel() {
		
	}
}
