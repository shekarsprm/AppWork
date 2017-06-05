package com.iws.appportal.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesUtility {

	private static Properties configProp = new Properties();

	public static String getPropertiesValue(String keyName) {
		try {
			InputStream is = PropertiesUtility.class.getClassLoader()
					.getResourceAsStream("app.properties");
			configProp.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = configProp.getProperty(keyName);
		return value;
	}

	public static void main(String[] args) {
	  System.out.println(getPropertiesValue("2"));	
	}
}
