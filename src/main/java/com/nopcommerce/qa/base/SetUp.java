package com.nopcommerce.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import com.nopcommerce.qa.Enum.AddressOfFiles;
import com.nopcommerce.qa.Enum.TimeUnits;


public class SetUp {

	protected static Properties prop;
	protected static WebDriver driver;
	static String url = "";
	static String browser = "";
	protected static String email="";
	protected static String pass="";

	/**
	 * This Base Constructor is used to initialize the property file 
	 */

	protected SetUp() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(AddressOfFiles.configFile);
			try {
				prop.load(fis);
				browser = prop.getProperty("browser");
				url = prop.getProperty("url");
				email=prop.getProperty("email");
				pass=prop.getProperty("password");
				
				

			} catch (IOException e) {
				System.out.println("Config File Not Loaded");
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Config File Not Found ");
			e.printStackTrace();
		}

		

	}
  
	/** This method will initiliaze the browser it will read the data from
	 * config file and accordingly open the browser */
	public void initilization() {
		

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {

			try {
				throw new Exception(browser + "Browser Not Found ");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeUnits.PAGE_LOAD_TIME));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeUnits.IMPLICIT_WAIT));
		driver.manage().window().maximize();
	//	Login();
	}
	
	public static void Login()
	{
		driver.findElement(By.xpath("//input[@placeholder='Enter username']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	
	
	/** Hooks */
	@BeforeTest
	public void openBrowser()
	{
		initilization();
	}
	

	

}
