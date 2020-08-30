package com.cognizant.iseek;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.Timestamp;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IseekGenerator {
	public static DesiredCapabilities dc;
    public static WebDriver driver; 
    public static  String timestamp;
    public static String filestamp;
    
	public static WebDriver createWebDriver()
    {

    	dc = DesiredCapabilities.chrome();		
		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.merge(dc);
    	System.setProperty("webdriver.chrome.driver", "./" + "Drivers/chromedriver.exe");
		driver = new ChromeDriver(chromeOptions);
		return driver;
    }
	
	public static void getCurrentTime()
	{
		timestamp = new Timestamp(System.currentTimeMillis()).toString();
		timestamp = timestamp.substring(0, timestamp.length() - 6).replaceAll(":", "");
		filestamp = "./" + "\\iseekReport" + " " + timestamp;
		System.out.println(filestamp);
	}
	
	public static void closeDriver()
	{
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		// TODO Auto-generated method stub
		
		createWebDriver();
		getCurrentTime();
		PageBangalore.pageBangaloreTest(driver,filestamp);
		PageKolkata.pageKolkataTest(driver, filestamp);
		PagePune.pagePuneTest(driver, filestamp);
		closeDriver();
		
	}

	
}
