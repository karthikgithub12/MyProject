package com.sathya.qa.Util;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TestUtil { 
	

		public static long PAGE_LOAD_TIMEOUT = 20;
		public static long IMPLICITY_TIMEOUT = 10;
		
		
		public static void screenshot(WebDriver driver, String Screenname) {
			try {
				
				File screen= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(screen, new File("F:\\Testing\\"+Screenname+".jpeg"));
				
			} catch (Exception e) {
				
				System.out.println( e.getMessage());
			}
				
		}
}
