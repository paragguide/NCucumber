package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Page;

public class ScreenShot extends Page
{
	public static void takeScreenShot(String scrname) throws Exception
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File f =	ts.getScreenshotAs(OutputType.FILE); // stores screen shot in temp file
		
		String screenshotpath = System.getProperty("user.dir")+"//src//test//java//screenshot//"+scrname+".jpg";
		
		FileUtils.copyFile(f, new File(screenshotpath));
		//System.out.println("screen shot taken..");
		test.log(Status.INFO, MarkupHelper.createLabel( "Screen shot taken ", ExtentColor.BLUE));

	}

}
