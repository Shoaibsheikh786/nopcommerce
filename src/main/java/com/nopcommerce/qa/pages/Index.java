package com.nopcommerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.qa.base.SetUp;
import com.nopcommerce.qa.utility.EleInt;

public class Index extends SetUp{
	
     @FindBy(xpath="//input[@id='Email']")
     WebElement email;
     
     @FindBy(xpath="//input[@id='Password']")
     WebElement password;
     
     @FindBy(xpath="//button[normalize-space()='Log in']")
     WebElement login;
     
     
     public  Index()
     {
    	 PageFactory.initElements(driver, this);
     }
     
     public void enterUsername()
     {
    	   email.sendKeys(SetUp.email);
     }
     public void enterPassword()
     {
    	  password.sendKeys(SetUp.pass);
     }
     public void login()
     {
    	EleInt.clickIfPresent(driver, login); 
     }
    
	
}
