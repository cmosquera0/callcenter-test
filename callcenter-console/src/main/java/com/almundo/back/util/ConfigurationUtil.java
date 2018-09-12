package com.almundo.back.util;

import java.io.IOException;
import java.util.Properties;

public class ConfigurationUtil {
	
	private static ConfigurationUtil instance;
	private static Properties config;// = new Properties();
	
	public static ConfigurationUtil getInstance() {
		if (instance == null) {
			instance = new ConfigurationUtil();
		}
		
		return instance;
	}
	
	public ConfigurationUtil() {
		config = new Properties();
		
		try {
			config.load(ClassLoader.getSystemResourceAsStream("config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No existe archivo de configuracion: config.properties");
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key) {
		return config.getProperty(key);
	}

}
