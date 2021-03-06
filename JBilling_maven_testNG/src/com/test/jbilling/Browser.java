package com.test.jbilling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.MarionetteDriverManager;

public class Browser {
	protected static WebDriver driver;
	protected static String baseurl;
	
  @BeforeSuite
  public void setup() {
  	  System.setProperty("webdriver.gecko.driver","/home/amit/Downloads/GeckoDriver/geckodriver");
  	  MarionetteDriverManager.getInstance().setup();
 	  driver = new MarionetteDriver();
	  baseurl = "http://localhost:8080/";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  public static WebDriver getBrowser(){
	  if(null == driver){
		  driver = new MarionetteDriver();
	  }
	  return driver;
  }
  
  @AfterSuite
  public void tearDown(){
	  driver.quit();
  }
}
