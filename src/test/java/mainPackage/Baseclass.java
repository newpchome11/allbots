package mainPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import accessibility.accessibilityTest;

public class Baseclass {
	DriverUtility d;
	public static WebDriver driver;
	public static Commonfunction commonFunctions;
	accessibilityTest accy;
	ExtentTest logger;
	
	public static Properties prop = new Properties();

	@BeforeTest
	public void openBrowser() throws IOException, InterruptedException {
		loadpropertiesfile();
		d = new DriverUtility();
		driver = d.getDriver(prop.getProperty("browserType"));
		driver.get(prop.getProperty("URL"));
		commonFunctions=PageFactory.initElements(driver,Commonfunction.class);
	} 
	
	@Test
	public void regression() throws Exception {
		commonFunctions=PageFactory.initElements(driver,Commonfunction.class);
		System.out.println("Running Regression");
		commonFunctions.writeExcel();
		commonFunctions.getExcel();
		commonFunctions.getReport();
		
		// FB
		//commonFunctions.applicationLogin();
	    //commonFunctions.fbGetStarted();
		
		// TWC/KDOL/NYDOL/CA/Arizona
		//commonFunctions.LanguageSelect();
		
		//NYDOLDF
		//commonFunctions.NYDOLDFLanguageSelect();
		
		// DOR
		//commonFunctions.categoryClick();
		//commonFunctions.subCategoryClick();
     	//commonFunctions.innerSubCategoryClick();
		//commonFunctions.feedbackflow();
		
		// ZD
		//commonFunctions.framechangeZD();
		
		// HE
		//commonFunctions.categoryDropdown(prop.getProperty("Sub-industries"), prop.getProperty("Platforms"), prop.getProperty("Language"));
		//commonFunctions.framechangeHE();
		
		//TNDHS Liveagent
		//commonFunctions.dhsliveagent();
		
		//commonFunctions.calsawsLogin();
		
		//TX Medicaid
		//commonFunctions.framechangeMC();
		//commonFunctions.LanguageSelect();
		
		// Common
		//commonFunctions.getResult(prop.getProperty("Application"));
	}
	
	@Test(enabled = false)
	public void accessibility() throws Exception {
		accy= new accessibilityTest();
		System.out.println("Running Accessibility");
		accy.a11y(driver);
	}
	
	
	public void loadpropertiesfile() throws IOException {
		String filepath = "./Config.properties";
		FileInputStream file = new FileInputStream(filepath);
		prop.load(file);
		System.out.println("prop file loaded");
	}
	
	@AfterTest
	public void browserclose() throws Exception {
	//driver.close();
	}
}
