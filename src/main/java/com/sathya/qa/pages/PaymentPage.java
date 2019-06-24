package com.sathya.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sathya.qa.Util.TestUtil;
import com.sathya.qa.base.ExcelRead;
import com.sathya.qa.base.TestBase;

public class PaymentPage extends TestBase{
	public PaymentPage() throws IOException {
		super();
	}

	WebDriver driver;
	ExcelRead obj= new ExcelRead("F:\\Testing\\Sathya_data.xlsx");

	@BeforeTest()
	public void browser() {
		//Open Firefox Browser with Sathya web site		
		 driver= TestBase.initialization("firefox");
		 driver.get("https://www.sathya.in/");

		 //Print in console
		 System.out.println("Sathya Website Opened");
	}
		
	@Test(priority=1)
	public void testcase1() throws InterruptedException{
		//Click Home Appliance DropDown button
	      WebElement menu=driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
	      Actions actions = new Actions (driver);
	      actions.moveToElement(menu).perform();
	      
	      //Click Kitchen Appliances 
	      driver.findElement(By.linkText("Kitchen Appliances")).click();
	      System.out.println("Kitchen Appliances Page Opened");
	      
	      //Open Induction Stove
	      driver.findElement(By.xpath("//a[@class='art-picture img-center-container']")).click();
	      
	      //Open First Induction Stove
	      driver.findElement(By.xpath("//a[@title='Prestige Indcook  PIC 20.0']")).click();
	      driver.findElement(By.xpath("//button[@class='btn btn-secondary bootstrap-touchspin-up']")).click();
	      driver.findElement(By.xpath("//i[@class='fa fa-cart-arrow-down']")).click();
	      Thread.sleep(4000);
	      driver.findElement(By.xpath("//*[@id=\"occ-cart\"]/div[2]/div/div[2]/div[2]/a/i")).click();
	      Thread.sleep(4000);
	      driver.findElement(By.xpath("//a[@class='btn btn-secondary btn-lg btn-block checkout-as-guest-button']")).click();
	      Thread.sleep(4000);
}

	@Test(priority=2)
	public void Excel() throws IOException, InterruptedException{
	      //Feed data from excel to delivery Address details
      	  driver.findElement(By.xpath("//*[@id=\"NewAddress_Company\"]")).sendKeys(obj.getdata(0, 0, 0));
 	      driver.findElement(By.id("NewAddress_FirstName")).sendKeys(obj.getdata(0, 0, 1));
 	      driver.findElement(By.id("NewAddress_LastName")).sendKeys(obj.getdata(0, 0, 2));
 	      driver.findElement(By.id("NewAddress_Address1")).sendKeys(obj.getdata(0, 0, 3));
 	      driver.findElement(By.id("NewAddress_Address2")).sendKeys(obj.getdata(0, 0, 4));
 	      driver.findElement(By.id("NewAddress_City")).sendKeys(obj.getdata(0, 0, 5));
 	      driver.findElement(By.id("NewAddress_ZipPostalCode")).sendKeys(obj.getdata2(0, 0, 6));
 	      driver.findElement(By.xpath("//*[@title='Select country']")).click();
	      Thread.sleep(1000);
	      driver.findElement(By.xpath("//li[@role='treeitem'][2]")).click();
	      Thread.sleep(1000);
 	      driver.findElement(By.id("NewAddress_Email")).sendKeys(obj.getdata(0, 0, 7));
 	      driver.findElement(By.id("NewAddress_PhoneNumber")).sendKeys(obj.getdata2(0, 0, 8).toString());
	      Thread.sleep(4000);
	}
	@Test(priority=3)
	public void Payment(){
	driver.findElement(By.xpath("//button[@class='btn btn-warning btn-lg new-address-next-step-button']")).click();
	driver.findElement(By.xpath("//button[@class='btn btn-warning btn-block select-shipping-address-button']")).click();
	driver.findElement(By.xpath("//button[@class='btn btn-warning btn-lg shipping-method-next-step-button']")).click();
	driver.findElement(By.xpath("//button[@class='btn btn-warning btn-lg payment-method-next-step-button']")).click();
	}
	@Test(priority=4)
	public void Screen(){
		TestUtil.screenshot(driver, "Checkout");
		String Expected ="Checkout";
		String Actual= driver.getTitle();
	    if (Expected.contains(Actual));

	}
	
	@Test(priority=5)
	public void Assert(){
		org.testng.Assert.assertEquals("Checkout", driver.getTitle());
	      System.out.println("Title Matched");
	 }
	
	@AfterTest
	public void teardown() {
		driver.close();
	}

}
