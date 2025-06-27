package mainPackage;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReport extends Commonfunction {
	
	public ExtentReport(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public ExtentReports generatereport() {
		
		Date d = new Date();

		String reportPath = "./Report/Regression_ExtentReports/" + prop.getProperty("Application") + "_DefectReport_" + prop.getProperty("Environment") + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
		ExtentReports extent = new ExtentReports(reportPath, true, DisplayOrder.OLDEST_FIRST);
		extent.loadConfig(new File("./Reportcon.xml"));
		extent.addSystemInfo("Category", Category);
		extent.addSystemInfo("SubCategory", SubCategory);
		extent.addSystemInfo("InnerSubCategory", InnerSubCategory);
		extent.addSystemInfo("Environment", prop.getProperty("Environment"));
		extent.addSystemInfo("URL", prop.getProperty("URL"));
		
		return extent;
	}
}
