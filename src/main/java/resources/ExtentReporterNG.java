package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	ExtentReports extent;
	public ExtentReports getReportObject()
	{

	String path=System.getProperty("user.dir") + "\\reports\\index.html";
	ExtentSparkReporter esr=new ExtentSparkReporter(path);
	esr.config().setDocumentTitle("Sample Doc Title");
	esr.config().setReportName("Sample Reort Name");
	
	extent=new ExtentReports();
	extent.attachReporter(esr);
	extent.setSystemInfo("Tester", "Sample Tester");
	return extent;
	
	}
}
