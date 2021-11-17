package FWBPrac;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@Test(dataProvider="getData")
	public void loginFunctionalitycheck(String Username,String Password,String text) throws IOException
	{
		driver=initializeDriver();
	log.info("Initialized for HomePage");
		
		
		driver.get("http://qaclickacademy.com/");
		log.info("Navigated to home page under basePageNavigation Home-Page");
		LandingPage l=new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		log.info(text);
		lp.getLogin().click();
		
	}
	
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3];
		
		data[0][0]="a@gmail.com";
		data[0][1]="S@2025trp";
		data[0][2]="nonRestricted user";
		
		data[1][0]="b@gmail.com";
		data[1][1]="D@2025trp";
		data[1][2]="Restricted user";
		
		return data;
		
	}

}
