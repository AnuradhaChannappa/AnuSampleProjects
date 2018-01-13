package com.cafetownsend.test.library;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ManageProperties {
	public Properties read() {

		return read("src/test/java/cafeTownSendconfig.properties");

	}

	public Properties read(String propFile) {

		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream(propFile);

			// load a properties file
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}
}
