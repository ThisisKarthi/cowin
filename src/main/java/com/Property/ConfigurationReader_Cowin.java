package com.Property;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader_Cowin {

	public Properties p; // declared as Class variable

	public ConfigurationReader_Cowin() throws IOException {
		File f = new File(
				"C:\\Users\\ANBU\\Desktop\\workspace selenium\\Cowin.gov.vaccine\\src\\main\\java\\com\\Property\\Cowin.Properties");

		FileInputStream fi = new FileInputStream(f);

		p = new Properties(); // declared as an local variBLE.

		p.load(fi);
	}

	public String getBrowser() {
		String browser = p.getProperty("browser");
		return browser;

	}

	public String geturl() {
		String url = p.getProperty("url");
		return url;

	}
}
