package com.nopcommercec.qa.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nopcommerce.qa.base.SetUp;
import com.nopcommerce.qa.pages.Index;

public class IndexTest  extends SetUp{
	
	Index ind;
	
	@BeforeTest()
	public void beforTest()
	{
		ind=new Index();
	}
	
	
	@Test
	public void test1()
	{
		ind.enterUsername();
		ind.enterPassword();
		ind.login();
	}
}
