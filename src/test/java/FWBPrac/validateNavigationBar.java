package FWBPrac;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import resources.base;

public class validateNavigationBar extends base {
	
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@Test
	public void validationOfNavigationBar() throws IOException {
		driver = initializeDriver();
		log.info("Initialized for basePageNav");
		
		driver.get("http://qaclickacademy.com/");
		log.info("Navigated to home page under basePageNavigation");
		
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavBar().isDisplayed());
		System.out.println("Nav Bar is Displayed-print 1");
		System.out.println("Nav Bar is Displayed-print 2");
		System.out.println("_____________________");
		System.out.println("Nav Bar is Displayed-print 4,5,6 get deleted by 1st user");
	
		log.info("Nav Bar is Displayed");

	}

}
