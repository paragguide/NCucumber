package testcases;

import java.util.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearch 
{
public boolean log= false;
	@Given("i am loggedin")
	public void i_am_loggedin() 
	{
	    if(PasswordTest.login == true)
	    {
	    	log = true;
	    }
	    else
	     {
	    	 Hook.test.log(Status.FAIL, MarkupHelper.createLabel( "Cannot search Login before. ", ExtentColor.RED));
				  	 
	     }
	}
	@When("^i search for product (.*) in range (.*)")
	public void i_search_for_product_in_range(String productname,int price) 
	{
	    if(log == true)
	    {
	    	Hook.productsearchbox.clear();
	  	  Hook.productsearchbox.sendKeys(productname);
	  	  
	  	  Hook.test.log(Status.PASS, MarkupHelper.createLabel( "search product.. "+productname, ExtentColor.GREEN));
	  		
	  	  Actions a = new Actions(Hook.driver);
	  	  a.sendKeys(Keys.ENTER).perform();
	  	  
	  	}
	}
	@Then("i should get results")
	public void i_should_get_results() 
	{
		Iterator <WebElement> it =   Hook.productresults.iterator();
  	    
	  	   while(it.hasNext())
	  	   {
	  		   WebElement e = it.next();
	  		   Hook.test.log(Status.PASS, MarkupHelper.createLabel( "search result.. "+e.getText(), ExtentColor.GREEN));
	  			 
	  	   }
	   // Hook.afterTest();
	}
}
