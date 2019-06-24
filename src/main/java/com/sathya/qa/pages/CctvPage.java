package com.sathya.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sathya.qa.base.TestBase;

/*
 * author: Karthikeyan
 * This page for Test CCTV page in Sathya Website
 */


public class CctvPage extends TestBase{


	//Page Factory-OR
	@FindBy(linkText="Security Solutions")
	WebElement Security;
	
	@FindBy(xpath="//span[@class=\\\"has-count\\\"][text()='CCTV Camera']")
	WebElement CctvCamera;
	
public CctvPage() {
PageFactory.initElements(driver, this);	
}

}
