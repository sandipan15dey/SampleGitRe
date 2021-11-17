package FWBPrac;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import resources.base;

public class validateTitle extends base{
	
	LandingPage l;
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	
	public void bm() throws IOException
	{
		driver=initializeDriver();
		log.info("Initialized for basePageNavigation");
		
		driver.get("http://qaclickacademy.com/");
		log.info("Navigated to home page under basePageNavigation method");
	}
	@Test
	public void validationOfTitle() throws IOException
	{
		
		
		l=new LandingPage(driver);
		
		System.out.println("_______________");
		Assert.assertEquals(l.getTitle().getText(),"FEATURED C123OURSES");
		//log.info("Initialized for basePageNavigation text c");
	}
	
	@Test
	public void validateHeader()
	{
		
		l=new LandingPage(driver);
		Assert.assertEquals(l.getHeader().getText(), "An Academy to learn Everything about Testing");
	}
	

}
