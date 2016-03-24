package Android.Android;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.TakesScreenshot;


public class Calendar {
	
  AndroidDriver driver;
  String destDir;
  DateFormat dateformat;
  @Test
  public void main() throws InterruptedException {
	  
	  //driver.findElement(By.id("android:id/action_bar_spinner")).click();
	  
	  //driver.findElement(By.name("Dec 2015")).click();
	  
	  Dimension size = driver.manage().window().getSize();
	  System.out.println(size);
	  
	  int startx = (int) (size.width * 0.2);
	  int endx = (int) (size.width * 0.6);
	  int starty = (int) (size.height * 0.4);
	  
	  System.out.println("startx, endx, starty" + startx + endx + starty);
	  
	  driver.swipe(startx, starty, endx, starty, 2000);
	  
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  //WebElement  P1 = ((WebElement) driver.findElements(By.xpath("//android.widget.ListView[@index='3']"))).findElement(By.xpath("//android.view.View[@index='0']"));
	  //WebElement  P2 = ((WebElement) driver.findElements(By.xpath("//android.widget.ListView[@index='3']"))).findElement(By.xpath("//android.view.View[@index='3']"));
	  
	  //TouchAction action = new TouchAction((MobileDriver) driver); 
	  
	  //System.out.println("Drag.");
	  //action.longPress(P1).moveTo(P2).release().perform();
	  takeScreenShot();
	  
	  
	  System.out.println("Finish");
  }
  
  public void takeScreenShot(){
	  destDir = "screenshots";
	  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  dateformat = new SimpleDateFormat("dd-MM-yyyy__hh__mm_ssaa");
	  
	  new File(destDir).mkdirs();
	  
	  String destFile = dateformat.format(new Date()) + ".png";
	  
	  try{
		  FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
	  } catch (IOException e){
		  e.printStackTrace();
	  }
	  
  }
  
  @BeforeTest
  public void beforeTest() throws Exception {
		// Created object of DesiredCapabilities class.
		  DesiredCapabilities capabilities = new DesiredCapabilities();

		  // Set android deviceName desired capability. Set your device name.
		  capabilities.setCapability("deviceName", "emulator-5554");

		  // Set BROWSER_NAME desired capability. It's Android in our case here.
		  capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

		  // Set android VERSION desired capability. Set your mobile device's OS version.
		  capabilities.setCapability(CapabilityType.VERSION, "5.1.1");

		  // Set android platformName desired capability. It's Android in our case here.
		  capabilities.setCapability("platformName", "Android");

		  // Set android appPackage desired capability. It is
		  // com.android.calculator2 for calculator application.
		  // Set your application's appPackage if you are using any other app.
		  //capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		  capabilities.setCapability("appPackage", "com.android.calendar");

		  // Set android appActivity desired capability. It is
		  // com.android.calculator2.Calculator for calculator application.
		  // Set your application's appPackage if you are using any other app.
		  //capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		  capabilities.setCapability("appActivity", "com.android.calendar.AllInOneActivity");

		  // Created object of RemoteWebDriver will all set capabilities.
		  // Set appium server address and port number in URL string.
		  // It will launch calculator app in android device.
		  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  WebDriverWait wait = new WebDriverWait(driver, 300);
		  wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout")));
	  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
