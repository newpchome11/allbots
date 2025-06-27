package mainPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;

public class UITesting {
	DriverUtility d;
	WebDriver driver;
	String Applitool_API_Key = "97K1An6RP1nc1087wE0RXOgbf8NukRf1ieStodO89CjIps110";
	public static Properties prop = new Properties();
	
	@Test
	public void visualTestValidation() throws IOException  {
		loadpropertiesfile();
		System.out.println("Test Started");
		Eyes eyes = new Eyes();
		d = new DriverUtility();
		driver = d.getDriver(prop.getProperty("browserType"));
		eyes.setApiKey(Applitool_API_Key);
		driver = eyes.open(driver, prop.getProperty("Application"), "Verify HomePage", new RectangleSize(1920, 1168));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		eyes.checkWindow("Homepage");
		//eyes.check("Homepage", Target.window().ignore(By.id("dynamic-ad")));
		eyes.check("Homepage", Target.window());
		TestResults results = eyes.close(false);
		if(results.isPassed()) {
			System.out.println("Test passed");
		}
		else {
			System.out.println("Test failed");
		}
		
	}
	
	public void loadpropertiesfile() throws IOException {
		String filepath = "./Config.properties";
		FileInputStream file = new FileInputStream(filepath);
		prop.load(file);
		System.out.println("prop file loaded");
	}
	

}
