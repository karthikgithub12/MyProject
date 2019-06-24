package com.sathya.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sathya.qa.Util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException {
try {
prop=new Properties();
FileInputStream input = new FileInputStream ("C:\\Users\\Karthikeyan\\eclipse-workspace\\MavenSathya\\src\\main\\java\\com\\sathya\\qa\\config\\config.properties");
prop.load(input);		
}
catch (FileNotFoundException e)
{
	e.printStackTrace();
}
catch (IOException e)
{
e.printStackTrace();
}
}

	
public static WebDriver initialization(String browser)
{
	browser=prop.getProperty("browser");
	if (browser.equals("chrome"))
	{
		System.setProperty("webderiver.chrome.driver", "C:\\\\New_folder\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
	}else if (browser.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\New_folder\\geckodriver\\geckodriver.exe");
		driver=new FirefoxDriver();
	}else if(browser.equals("Edge"))
	{
		System.setProperty("webdriver.edge.driver", "C:\\New_folder\\MicrosoftWebDriver.exe");
		driver=new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITY_TIMEOUT, TimeUnit.SECONDS);

	driver.get(prop.getProperty("url"));
	return driver;
}
}
