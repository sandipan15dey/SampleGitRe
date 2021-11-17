package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
	public WebDriver driver;
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.cssSelector(".text-center>h2");
	By NavBar=By.cssSelector(".text-center>h2");
	By Header=By.cssSelector("div[class*='video-banner'] h3");
	By popup=By.xpath("//button[text()='NO THANKS']");
	
	public LandingPage(WebDriver driver) 
	{

	this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}

	public WebElement getNavBar()
	{
		return driver.findElement(NavBar);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(Header);
	}
	
	public WebElement getpopUp()
	{
		return driver.findElement(popup);
	}
	
	public int getpopUp2()
	{
		return driver.findElements(popup).size();
	}
}
