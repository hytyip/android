package Android.Android;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.TakesScreenshot;



public class Chrome {
	WebDriver driver;
  @Test
  public void main() throws Exception {
	  //Unlock phone screen
	  //Runtime.getRuntime().exec("adb shell am start -n io.appium.unlock/.Unlock");
	  //driver.get("http://www.google.com");
	  driver.get("http://192.168.1.92/Docman10_Instance/DocumentViewer/Documents");
	  //driver.findElement(By.id("lst-ib")).sendKeys("docman");
	  //driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
	  Thread.sleep(1000);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.id("dm-show-folders")).click();
	  Thread.sleep(3000);
	  Android.Android.Screenshot.takeScreenShot(driver);
	  
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  DesiredCapabilities capabilities = new DesiredCapabilities();

	  // Set android deviceName desired capability. Set your device name.
	  //capabilities.setCapability("deviceName", "6cbbda77");
	  capabilities.setCapability("deviceName", "emulator-5554");

	  // Set BROWSER_NAME desired capability. It's Android in our case here.
	  //capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
	  capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");

	  // Set android VERSION desired capability. Set your mobile device's OS version.
	  capabilities.setCapability(CapabilityType.VERSION, "5.1.1");

	  // Set android platformName desired capability. It's Android in our case here.
	  capabilities.setCapability("platformName", "Android");
	  //capabilities.setCapability("orientation", "LANDSCAPE");

	  //Additional Settings
	  capabilities.setCapability("disableAndroidWatchers", false);
	  capabilities.setCapability("deviceReadyTimeout", 30);
	  capabilities.setCapability("androidDeviceReadyTimeout", 30);
	  // Set android appPackage desired capability. It is
	  // com.android.calculator2 for calculator application.
	  // Set your application's appPackage if you are using any other app.
	  //capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
	  //capabilities.setCapability("appPackage", "com.android.calculator2");

	  // Set android appActivity desired capability. It is
	  // com.android.calculator2.Calculator for calculator application.
	  // Set your application's appPackage if you are using any other app.
	  //capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
	  //capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

	  // Created object of RemoteWebDriver will all set capabilities.
	  // Set appium server address and port number in URL string.
	  // It will launch calculator app in android device.
	  Thread.sleep(1000);
	  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
