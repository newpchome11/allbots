package mainPackage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtility {
	//input to the method is browser name
	//output from the method is webdriver instance
	
	public WebDriver driver;
	public String mobURL = "http://0.0.0.0:4723/wd/hub";
	
	public WebDriver getDriver(String browser) throws MalformedURLException {
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			
			//DesiredCapabilities caps = new DesiredCapabilities();
		    //caps.setBrowserName("chrome");
			
            //options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");
            //options.addArguments("disable-infobars"); // disabling infobars
            //options.addArguments("--disable-extensions"); // disabling extensions
            //options.addArguments("--disable-gpu"); // applicable to windows os only
			//options.addArguments("--no-sandbox");
            //options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            //options.setExperimentalOption("useAutomationExtension", false);
            System.setProperty("webdriver.chrome.driver","./Resource/chromedriver");
			//System.setProperty("webdriver.chrome.driver",UITesting.prop.getProperty("chromeDriver"));
            
            //options.setBinary("C:\\Users\\pramod.a.ramesh\\Downloads\\chrome-win64\\chrome.exe");
            options.addArguments("--headless");					
			//WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            //driver = new RemoteWebDriver(new URL("http://44.211.77.23:4444/wd/hub"), caps);
            return driver;
			}
		
		    else if(browser.equalsIgnoreCase("IE")) {
				/*
				 * DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				 * ieCapabilities.setCapability("nativeEvents", false);
				 * ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
				 * ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
				 * ieCapabilities.setCapability("disable-popup-blocking", true);
				 * ieCapabilities.setCapability("enablePersistentHover", true);
				 */
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
            return driver;

           
		}
		
		else if(browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		}
		
		else if(browser.equalsIgnoreCase("Opera")) {
			WebDriverManager.operadriver().setup();
			//driver = new OperaDriverManager();
			driver.manage().window().maximize();
			return driver;
		}
	
		else if(browser.equalsIgnoreCase("Edge")) {
			//WebDriverManager.edgedriver().setup();			
			//System.setProperty("webdriver.edge.driver", Baseclass.prop.getProperty("edgeDriver"));
			EdgeOptions options = new EdgeOptions();
			//options.addArguments("--headless");
			options.addArguments("--start-maximized");
		    driver = new EdgeDriver(options);
			//driver.manage().window().maximize();
			return driver;
		}
				
		else 
		{
		return null;
		}
		
	}

}
