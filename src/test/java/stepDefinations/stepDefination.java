package stepDefinations;

import org.junit.Assert;
import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resources.base;

@RunWith(Cucumber.class)
public class stepDefination extends base{
	
	 @Given("^Initialize browser with chrome$")
	    public void initialize_browser_with_chrome() throws Throwable {
		 driver=initializeDriver();
	    }

	 @When("^User enters (.+) and (.+) and logs in$")
	    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
	        
	    	LoginPage lp=new LoginPage(driver);
			lp.getEmail().sendKeys(username);
			lp.getPassword().sendKeys(password);
			
			lp.getLogin().click();
	    }

	    @Then("^Verify that user is successfully logged in$")
	    public void verify_that_user_is_successfully_logged_in() throws Throwable {
	        portalHomePage php=new portalHomePage(driver);
	        Assert.assertTrue(php.getQuery().isDisplayed());
	    }

	    @And("^Navigate to \"([^\"]*)\" site$")
	    public void navigate_to_something_site(String strArg1) throws Throwable {
	    	driver.get(strArg1);
	    }

	    @And("^Click on Login link in home page to land on Secure sign in Page$")
	    public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {

	    	LandingPage l=new LandingPage(driver);
	    	if(l.getpopUp2()>0)
	    	{
	    		l.getpopUp().click();
	    	}
			l.getLogin().click();
	    }

	    @And("^close Browser$")
	    public void close_browser() throws Throwable {
	        driver.quit();
	    }

}
