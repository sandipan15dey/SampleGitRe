package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalHomePage 
{
	public WebDriver driver;
	By searchE=By.name("query");
	
	
	public portalHomePage(WebDriver driver) 
	{

	this.driver=driver;
	}

	public WebElement getQuery()
	{
		return driver.findElement(searchE);
	}
	
	
}
