package Android.Android;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot{
	  
	  
	  public static void takeScreenShot(WebDriver driver){
		  String destDir;
		  DateFormat dateformat;
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

}

