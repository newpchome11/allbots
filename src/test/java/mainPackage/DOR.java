package mainPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import accessibility.accessibilityTest;

public class DOR {
	DriverUtility d;
	WebDriver driver;
	Commonfunction commonFunctions;
	accessibilityTest accy;
	ExtentTest logger;
	
	//public static Properties prop = new Properties();

	//@BeforeTest
	/*
	 * public void openBrowser() throws IOException, InterruptedException {
	 * loadpropertiesfile(); d = new DriverUtility(); driver =
	 * d.getDriver(prop.getProperty("browserType"));
	 * driver.get(prop.getProperty("URL")); }
	 */
	
	@Test
	public void regression() throws Exception {
		//commonFunctions=PageFactory.initElements(driver,Commonfunction.class);
		//System.out.println("Running Regression");
		//commonFunctions.writeExcel();
		//commonFunctions.getExcel();
		//commonFunctions.getReport();
		
		
		//Baseclass.commonFunctions.categoryClick();
		//Baseclass.commonFunctions.subCategoryClick();
     	//commonFunctions.innerSubCategoryClick();
		//commonFunctions.feedbackflow();
		Baseclass.commonFunctions.getResult(Baseclass.prop.getProperty("Application"));
	}
	
	
	/*
	 * public void loadpropertiesfile() throws IOException { String filepath =
	 * "./Config.properties"; FileInputStream file = new FileInputStream(filepath);
	 * prop.load(file); System.out.println("prop file loaded"); }
	 */
	
	@AfterTest
	public void browserclose() throws Exception {
	//driver.close();
	}
}
