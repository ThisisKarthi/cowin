package com.Property;

import java.io.IOException;

public class ConfigurationHelper_Cowin {
	public static ConfigurationReader_Cowin getInstance() throws IOException {

		ConfigurationReader_Cowin cr = new ConfigurationReader_Cowin();
		return cr;
	}

	private ConfigurationHelper_Cowin() {

	}

}
