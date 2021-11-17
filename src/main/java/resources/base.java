package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	
	{
		prop= new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\SANDIPAN\\eclipse-workspace\\FWBP\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	
	//String browserName=System.getProperty("browser");
	String browserName=prop.getProperty("browser");
	
	if(browserName.contains("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SANDIPAN\\Desktop\\Eclips\\c95\\chromedriver_win32\\chromedriver.exe");
		/*ChromeOptions co=new ChromeOptions();
		
		if(browserName.contains("headless"))
		{
			co.addArguments("--headless");
		}
		driver = new ChromeDriver(co);*/
		
		driver=new ChromeDriver();
	}
	
	if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SANDIPAN\\Desktop\\Eclips\\\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	if(browserName.equals("ie"))
	{
		System.setProperty("webdriver.ie.driver", "C:\\Users\\SANDIPAN\\Desktop\\Eclips\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+ testCaseName +".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
