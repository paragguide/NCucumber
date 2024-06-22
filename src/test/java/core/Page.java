package core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Page 
{
	
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static WebDriver driver = null;
	
	public void beforeTest(String testname,String browser,String url,String reportname)
	  {
		  
			  // initialize report..
			  extent = new ExtentReports();
				spark = new ExtentSparkReporter( System.getProperty("user.dir")+"//src//test//java//reports//"+reportname+".html" );
				extent.attachReporter(spark);
				spark.config().setDocumentTitle(reportname);
		        // Name of the report
		spark.config().setReportName(reportname);
		        // Dark Theme
		spark.config().setTheme(Theme.STANDARD);
		test = extent.createTest(reportname);
		
		   // open browser..
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.navigate().to(url); // prefer -> go back/forward/refresh
		
		test.log(Status.INFO, MarkupHelper.createLabel( "Browser "+browser+" with URL "+url+" opens ", ExtentColor.BLUE));

		
		PageFactory.initElements(driver, this); // read external xpath..
		
		// implicit wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		driver.manage().window().maximize();

		 
	  }
	  
	  
	 
	  public static void afterTest() 
	  {
		  driver.quit();
		  extent.flush();
	  }



}
