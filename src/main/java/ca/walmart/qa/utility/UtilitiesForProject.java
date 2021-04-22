package ca.walmart.qa.utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ca.walmart.qa.base.TestBase;

public class UtilitiesForProject extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 20;
	//public static long IMPLICIT_WAIT = 10;
	//public static long IMPLICIT_WAIT = 20;

	
	
		public static void takeScreenshotOfTest(WebDriver driver,String screenshotName) throws Exception  {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
			FileUtils.copyFile(scrFile, new File("C:\\Users\\DIRECTOR\\eclipse-workspace\\walmartProject\\src\\main\\java\\reportAttachment\\Screenshots"+screenshotName+".png"));
		}


}
