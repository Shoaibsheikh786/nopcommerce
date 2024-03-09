package com.nopcommerce.qa.utility;

import org.openqa.selenium.WebElement;

import org.testng.Assert;


public class Asser {

	public static void CheckButtonsTextOnWebpage(WebElement ele,String text)
	{
		Assert.assertEquals(ele.getText(),text);
	}
   
	
	/** @return 
	 * @return false if conditon is getting failed*/
	
	public static boolean notEquals(String s1,String s2)
	{
		return (!s1.equals(s2));
	}
	
	public static boolean Equals(String s1,String s2)
	{
		return (s1.equals(s2));
	}
	
}
