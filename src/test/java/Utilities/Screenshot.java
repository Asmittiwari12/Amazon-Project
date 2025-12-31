package Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public static String takeScreenshot(WebDriver driver ,String testname) throws IOException {
		File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Dell\\eclipse-workspace\\AmozonProject\\screenshot\\"+testname+"simple.png");
		FileHandler.copy(source, dest);
		return testname;
		
	}
}
