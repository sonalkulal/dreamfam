package com.meteorite.config;

import com.meteorite.utilities.FileUtility;

public class Configuration {
	
	public String getAppUrl(String env) {
	FileUtility file=new FileUtility();
	return file.getProperty("/src/main/resources/config.properties","app."+env+"url");
	}

}
