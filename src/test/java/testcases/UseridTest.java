package testcases;

import org.junit.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UseridTest extends Hook
{

	public static boolean userid = false;
	
	@Given("I execute testname {string} open {string} with url {string} and create report {string}")
	public void i_execute_testname_open_with_url_and_create_report(String testname, String browser, String url, String reportname) 
	{
		beforeTest(testname,browser,url,reportname);
	}
	@Given("click on signin link")
	public void click_on_signin_link() 
	{
	    signin.click();
	}
	@When("I enter valid userid {string}")
	public void i_enter_valid_userid(String email) 
	{
	    uid.sendKeys(email);
	}
	@When("click continue button")
	public void click_continue_button() 
	{
	    ctnbtn.click();
	}
	@Then("I validate the userid")
	public void i_validate_the_userid() 
	{
		 try {
			  test.log(Status.FAIL, MarkupHelper.createLabel( err1.getText(), ExtentColor.RED));
			   Assert.fail("userid is not valid..");
					
					    }
					catch(Exception e)
					    {
				test.log(Status.PASS, MarkupHelper.createLabel( "userid is valid.. ", ExtentColor.GREEN));
				userid = true;
					    }
	}

	

}
