package testcases;

import org.junit.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasswordTest 
{
	public static boolean login = false;
	public boolean uid = false;
	
	@Given("userid is valid")
	public void userid_is_valid() 
	{
	    if(UseridTest.userid == true)
	    {
	    	uid = true;
	    }
	}
	@When("i enter password {string}")
	public void i_enter_password(String pswd) 
	{
	   if(uid == true)
	   {
		   Hook.pwd.sendKeys(pswd);
		   Hook.submit.click();
	   }
	}
	@Then("i should login")
	public void i_should_login() 
	{
		try {
			  Hook.test.log(Status.FAIL, MarkupHelper.createLabel( Hook.err2.getText(), ExtentColor.RED));
			   Assert.fail("password is not valid..");
					
					    }
					catch(Exception e)
					    {
				Hook.test.log(Status.PASS, MarkupHelper.createLabel( "password is valid.. ", ExtentColor.GREEN));
				login = true;
					    }
			
	}

}
