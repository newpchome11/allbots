package mainPackage;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Commonfunction extends Baseclass {

	WebDriver driver;
	ExtentTest logger;
	ExtentReports extent;
	String Category="NA";
	String SubCategory="NA";
	String InnerSubCategory="NA";
	String actualresult = "";
	boolean isElementFound = true;
	int i;
	int m;
	int k = Integer.parseInt(prop.getProperty("rowStart"));
	int l = Integer.parseInt(prop.getProperty("rowEnd"));
	int pi;
	ExcelRead excelRead;
	ExcelWrite excelWrite;
	Object[][] obj1=null;
	
	/*
	 * @FindBy(xpath = "//textarea[@aria-label=\"userInput\"]") WebElement inputbox;
	 * 
	 * @FindBy(xpath = "//textarea[@id=\"question\"]") WebElement inputboxQ;
	 */
	
	@FindAll({
		@FindBy(xpath = "//textarea[@aria-label=\"userInput\"]"),
		@FindBy(xpath = "//textarea[@id='userInput']"),
		@FindBy(xpath = "//textarea[@id='question']"),
		@FindBy(xpath ="//div[@role='textbox']"),
		@FindBy(xpath ="//textarea[@name=\"chatBox\"]"),
		@FindBy(xpath ="//button[@aria-label='Chat']"),
		@FindBy(xpath = "//*[@id='1val-field_1.3.4--input']"),
		@FindBy(xpath = "//textarea[@id='wisdom']"),
		@FindBy(xpath = "//input[@id='userInput']"),
		@FindBy(xpath = "//input[@id='text-input']"),
		@FindBy(xpath = "//input[@name='text-input']"),
		@FindBy(xpath = "//textarea[@id='wisdom']")
		
	})
	WebElement inputbox;
	
	@FindBy(xpath = "//span[@class='category-label'][contains(text(),'Business Sales Tax')]")
	WebElement salesTax;

	// ST subcategory xpaths
	@FindBy(xpath = "//span[contains(text(),'Forms and Filing Inquiries')]")
	WebElement ST_FormsnFilingInquiries;

	@FindBy(xpath = "//span[contains(text(),'Overpayments')]")
	WebElement ST_Overpayments;

	@FindBy(xpath = "//span[contains(text(),'Check my Balance')]")
	WebElement ST_CheckmyBalance;

	@FindBy(xpath = "//span[contains(text(),'Pay My Taxes')]")
	WebElement ST_PayMyTaxes;

	@FindBy(xpath = "//span[contains(text(),'MyTax Account')]")
	WebElement ST_MyTaxAccount;

	@FindBy(xpath = "//span[contains(text(),'Registration / License')]")
	WebElement ST_RegistrationLicense;

	@FindBy(xpath = "//span[contains(text(),'Exemptions')]")
	WebElement ST_Exemptions;

	@FindBy(xpath = "//span[contains(text(),'General Questions')]")
	WebElement ST_GeneralQuestions;

	@FindBy(xpath = "//span[@class='category-label'][contains(text(),'Income Tax')]")
	WebElement incomeTax;

	// IT subcategory xpaths
	@FindBy(xpath = "//span[contains(text(),'Forms')]")
	WebElement IT_Forms;

	@FindBy(xpath = "//span[contains(text(),'Filing Inquiries')]")
	WebElement IT_Filing_Inquiries;

	@FindBy(xpath = "//span[contains(text(),'Individual Income Tax')]")
	WebElement IT_Individual_Income_Tax;

	@FindBy(xpath = "//span[contains(text(),'Property Tax Credit')]")
	WebElement IT_Property_Tax_Credit;

	@FindBy(xpath = "//span[contains(text(),'Corporate Income Tax')]")
	WebElement IT_Corporate_Income_Tax;

	@FindBy(xpath = "//span[contains(text(),'Refund / Return Status')]")
	WebElement IT_Refund_Return_Status;

	@FindBy(xpath = "//span[contains(text(),'Check My Balance')]")
	WebElement IT_Check_My_Balance;

	@FindBy(xpath = "//span[contains(text(),'Pay My Taxes')]")
	WebElement IT_Pay_My_Taxes;

	@FindBy(xpath = "//span[contains(text(),'General Questions')]")
	WebElement IT_GeneralQuestions;
	
	@FindBy(xpath = "//span[contains(text(),'MyTax Account')]")
	WebElement IT_MyTaxAccount;

	@FindBy(xpath = "//span[@class='category-label'][contains(text(),'Motor Vehicle')]")
	WebElement motorVehicle;

	// MV subcategory xpaths
	@FindBy(xpath = "//span[contains(text(),'Titling')]")
	WebElement MV_Titling;

	@FindBy(xpath = "//span[contains(text(),'Registration / License Plates')]")
	WebElement MV_RegistrationLicensePlates;

	@FindBy(xpath = "//span[contains(text(),'Missouri dealers')]")
	WebElement MV_Dealers;

	@FindBy(xpath = "//span[@class='category-label'][contains(text(),'Vehicle Renewal')]")
	WebElement vehicleRenewal;

	// VR subcategory xpaths
	@FindBy(xpath = "//span[contains(text(),'Plate Renewal')]")
	WebElement VR_PlateRenewal;

	@FindBy(xpath = "//span[contains(text(),'Personal Property Tax')]")
	WebElement VR_PersonalPropertyTax;

	@FindBy(xpath = "//span[@class='category-label'][contains(text(),'Driver License')]")
	WebElement driverLicense;

	@FindBy(xpath = "//span[@class='category-label'][contains(text(),'Employer Withholding Tax')]")
	WebElement withholdingTax;

	@FindBy(xpath = "//input[@aria-label=\"send\"]")
	WebElement send;

	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	WebElement yesButton;

	@FindBy(xpath = "(//span[contains(text(),'No')])[2]")
	WebElement noButton;

	@FindBy(xpath = "//span[contains(text(),'Okay. Please ask your question below')]")
	WebElement YesResponse;

	@FindBy(xpath = "//div[@class='feedBackText']")
	WebElement NoResponse;

	@FindBy(xpath = "//body//img[2]")
	WebElement feedbackTile;

	@FindBy(xpath = "Thank you for your feedback.")
	WebElement feedbackTileResponse;

	@FindBy(xpath = "//button[@class='caret-icon open-invert']")
	WebElement categoryToggle;

	@FindBy(xpath = "//span[contains(text(),'Great! What question about')]")
	WebElement categoryResponse;

	@FindBy(how = How.ID, using = "email")
	WebElement userName;
	@FindBy(how = How.ID, using = "pass")
	WebElement password;
	@FindBy(xpath="//span[text()='Get Started']")
	WebElement getstarted;
	
	// Columbia
	@FindBy(xpath = "//span[contains(text(),'Billing & Payments')]")
	WebElement BillingandPayments;

	@FindBy(xpath = "//span[contains(text(),'Transcripts & Diplomas')]")
	WebElement TranscriptsandDiplomas;

	@FindBy(xpath = "//span[contains(text(),'Forms')]")
	WebElement Forms;

	@FindBy(xpath = "//span[contains(text(),'Student Records')]")
	WebElement StudentRecords;

	@FindBy(xpath = "//span[contains(text(),'Registration')]")
	WebElement Registration;

	@FindBy(xpath = "//span[contains(text(),'Miscellaneous')]")
	WebElement Miscellaneous;

	// Self-Service Bot
	@FindBy(xpath = "//span[contains(text(),'MyUNI')]")
	WebElement MyUNI;

	@FindBy(xpath = "//span[contains(text(),'Duo')]")
	WebElement Duo;

	@FindBy(xpath = "//span[contains(text(),'Printing')]")
	WebElement Printing;

	@FindBy(xpath = "//span[contains(text(),'Email')]")
	WebElement Email;

	@FindBy(xpath = "//span[contains(text(),'Zoom')]")
	WebElement Zoom;

	@FindBy(xpath = "//span[contains(text(),'Other')]")
	WebElement Other;

	// Elements for DOR-FB

	@FindBy(xpath = "//div[@data-testid='messenger-chat-title-text']")
	WebElement clickOnsettings;
	@FindBy(xpath = "//span[contains(text(),'Send Message')]")
	WebElement clickOnSendMessage;
	@FindBy(xpath = "//span[contains(text(),'Delete conversation')]")
	WebElement clickonDeleteConversation;
	@FindBy(xpath = "//div[@aria-label=\"Delete Conversation\" and @tabindex=\"0\"]")
	WebElement clickonpopupDeleteConversation;

	@FindBy(xpath = "//a[@class=\"_2mgq\"]")
	WebElement accountName;

	@FindBy(xpath = "//span[contains(text(),'Sales Tax')]")
	WebElement DorFb_SalesTax;

	@FindBy(xpath = "//span[contains(text(),'Forms and Filing Inquir...')]")
	WebElement DorFb_ST_FormsandFilingInquiries;
	@FindBy(xpath = "//span[contains(text(),'Overpayments')]")
	WebElement DorFb_ST_OverPayments;
	@FindBy(xpath = "//span[contains(text(),'Check my Balance')]")
	WebElement DorFb_ST_CheckMyBalance;
	@FindBy(xpath = "//span[contains(text(),'Pay My Taxes')]")
	WebElement DorFb_ST_payMytaxes;
	@FindBy(xpath = "//span[contains(text(),'MyTax Account')]")
	WebElement DorFb_ST_MyTaxAccount;
	@FindBy(xpath = "//span[contains(text(),'Registration / License')]")
	WebElement DorFb_ST_RegistrationLicense;
	@FindBy(xpath = "//span[contains(text(),'Exemptions')]")
	WebElement DorFb_ST_Exemptions;
	@FindBy(xpath = "//span[contains(text(),'General Questions')]")
	WebElement DorFb_ST_GeneralQuestions;

	@FindBy(xpath = "//span[contains(text(),'Income Tax')]")
	WebElement DorFb_IncomeTax;
	@FindBy(xpath = "//span[contains(text(),'Forms')]")
	WebElement DorFb_IT_Forms;
	@FindBy(xpath = "//span[contains(text(),'Filing Inquiries')]")
	WebElement DorFb_IT_FilingInquiries;
	@FindBy(xpath = "//span[contains(text(),'Individual Income Tax')]")
	WebElement DorFb_IT_IndividualIncomeTax;
	@FindBy(xpath = "//span[contains(text(),'Property Tax Credit')]")
	WebElement DorFb_IT_PropertyTaxCredit;
	@FindBy(xpath = "//span[contains(text(),'Corporate Income Tax')]")
	WebElement DorFb_IT_CorporateIncomeTax;
	@FindBy(xpath = "//span[contains(text(),'Refund / Return Status')]")
	WebElement DorFb_IT_RefundreturnStatus;
	@FindBy(xpath = "//span[contains(text(),'Check My Balance')]")
	WebElement DorFb_IT_CheckMyBalance;
	@FindBy(xpath = "//span[contains(text(),'Pay My Taxes')]")
	WebElement DorFb_IT_PayMyTaxes;
	@FindBy(xpath = "//span[contains(text(),'General Questions')]")
	WebElement DorFb_IT_GeneralQuestions;

	@FindBy(xpath = "//span[contains(text(),'Motor Vehicle')]")
	WebElement DorFb_MotorVehicle;
	@FindBy(xpath = "//span[contains(text(),'Titling')]")
	WebElement DorFb_MV_Titling;
	@FindBy(xpath = "//span[contains(text(),'Registration / License ...')]")
	WebElement DorFb_MV_RegistrationLicenseplates;
	@FindBy(xpath = "//span[contains(text(),'Dealers')]")
	WebElement DorFb_MV_Dealers;

	@FindBy(xpath = "//span[contains(text(),'Vehicle Renewal')]")
	WebElement DorFb_VehicleRenewal;
	@FindBy(xpath = "//span[contains(text(),'Plate Renewal')]")
	WebElement DorFb_VR_PlateRenewal;
	@FindBy(xpath = "//span[contains(text(),'Personal Property Tax')]")
	WebElement DorFb_VR_PersonalpropertyTax;

	@FindBy(xpath = "//span[contains(text(),'Driver License')]")
	WebElement DorFb_DriverLicense;
	@FindBy(xpath = "//span[contains(text(),'Withholding Tax')]")
	WebElement DorFb_Withholdingtax;

	// Zendesk
	@FindBy(xpath = "//textarea[@name=\"chatBox\"]")
	WebElement inputboxZD;

	@FindBy(xpath = "//*[@id='1val-field_1.3.4--input']")
	WebElement Chatbox;

	@FindBy(xpath = "//button[@aria-label=\"Popout\"]")
	WebElement popout;
	
	@FindBy(xpath = "//iframe[@id='launcher']")
	WebElement iframeZD1;
	
	@FindBy(xpath = "//iframe[@id='webWidget']")
	WebElement iframeZD2;

	//Languages
	@FindAll({
		@FindBy(xpath = "//div[@class=\"button\"]//span[contains(text(),'English')]"),
		@FindBy(xpath = "//div[@class='button button_Iframe']//span[contains(text(),'English')]"),
		@FindBy(xpath="//button[@class=\"button\"]//span[contains(text(),'English')]"),
		@FindBy(xpath="//button[contains(text(),'English')]"),
		@FindBy(xpath="(//btn[@id='btnIds'])[1]"),
		@FindBy(xpath="//div[normalize-space()='English']")
		
	})
	WebElement english;
	
	@FindAll({
	@FindBy(xpath = "//div[@class=\"button\"]//span[contains(text(),'Español')]"),
	@FindBy(xpath = "//div[@class='button button_Iframe']//span[contains(text(),'Español')]"),
	@FindBy(xpath="//button[@class=\"button\"]//span[contains(text(),'Español')]"),
	@FindBy(xpath="//button[contains(text(),'Spanish')]"),
	@FindBy(xpath="(//btn[@id='btnIds'])[2]"),
	@FindBy(xpath="//div[normalize-space()='Español']")
	})
	WebElement spanish;
	
	@FindBy(xpath = "//span[contains(text(),'I have general questions')]")
	WebElement mddolButton;
	
	@FindBy(xpath = "//div[@class=\"button\"]//span[contains(text(),'COVID-19 Vaccine')]")
	WebElement covidVaccine;
	
	@FindBy(xpath = "//div[@class=\"button\"]//span[contains(text(),'Flu Vaccine')]")
	WebElement fluVaccine;
	
	@FindBy(xpath = "//div[@class=\"button\"]//span[contains(text(),'Monkeypox Vaccine')]")
	WebElement monkeypoxVaccine;
	
	@FindAll({
	@FindBy(xpath = "//input[@class=\"submitButtonActive\"]"),
	@FindBy(xpath = "//input[@class=\"submitButton\"]")
	})
	WebElement submit;
		
	//Higher Education
	@FindBy(xpath = "//div[@id='industries-selection-box']")
	WebElement Sub_industriesDropDown;
	
	@FindBy(xpath = "//div[@id='platforms-selection-box']")
	WebElement PlatformsDropDown;
	
	@FindBy(xpath = "//div[@id='languages-selection-box']")
	WebElement LanguageDropDown;
	
	@FindBy(xpath = "//div[@class=\"chatbot-open\"]//p[contains(text(),'Open Virtual Assistant')]")
	WebElement Open_VA;
	
	@FindBy(xpath = "//iframe[@id='chatbot-iframe']")
	WebElement iframeHE;
	
	@FindBy(xpath = "//img[@id='iframe-close-icon']")
	WebElement iframeClose;
	
	@FindBy(xpath = "//df-messenger[@intent='WELCOME']")
	WebElement messangerNYDOLDF;
	
	@FindBy(xpath = "//button[contains(text(),'I need help creating my account')]")
	WebElement buttonINeedHelp;
	
	@FindBy(xpath = "//button[contains(text(),'Connect me with an agent')]")
	WebElement buttonConnectAgent;
	
	@FindBy(xpath = "//input[@value='Cancel']")
	WebElement buttonCancel;
	
	@FindBy(xpath = "//input[@id='idToken1']")
	WebElement csUsernamePwd;
	
	@FindBy(xpath = "//input[@id='loginButton_0']")
	WebElement csLogin;
	
	@FindBy(xpath = "//input[@id='idToken2_0']")
	WebElement csAccept;
	
	@FindBy(xpath = "//div[@id='headertext-chat-off']")
	WebElement botHeader;
	
	@FindBy(xpath = "//iframe[@id='chat-frame']")
	WebElement mciFrame;
	
	
	public void applicationLogin() throws Exception {
		userName.sendKeys(prop.getProperty("un3"));
		password.sendKeys(prop.getProperty("pwd3"));
		password.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	public void fbGetStarted() throws Exception {
		driver.get("https://www.facebook.com/DOR-Bot-Dev-105980987641387");
		Thread.sleep(3000);
		try {
			System.out.println("Delete Message");
			clickOnsettings.click();
			Thread.sleep(2000);
			clickonDeleteConversation.click();
			Thread.sleep(2000);
			clickonpopupDeleteConversation.click();
			Thread.sleep(3000);
			clickOnSendMessage.click();
			Thread.sleep(3000);
			getstarted.click();
			Thread.sleep(6000);
		}
		catch(Exception e) {
			clickOnSendMessage.click();
			Thread.sleep(2000);
			System.out.println("Not Deleting Message");
			clickOnsettings.click();
			Thread.sleep(2000);
			getstarted.click();
			Thread.sleep(6000);
		}			
		}
		
	public void LanguageSelect() throws Exception {
		//Common
		//explicitWait("(//span[@id=\"message-span\"])[1]");
		
		//Arizona
		explicitWait("(//div[@class='message-text'])[1]");
		
		english.click();
		
		//CA
		//explicitWait("(//span[@id=\"message-span\"])[2]");
		//covidVaccine.click();
		
	}
	
	public void NYDOLDFLanguageSelect() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Thread.sleep(500);	
		//WebElement welcomeMessage=(WebElement)jse.executeScript("return document.querySelector('df-messenger').shadowRoot.querySelector('df-messenger-chat').shadowRoot.querySelector('df-message-list').shadowRoot.querySelectorAll('div').item(2).children.item(0)");		
		//welcomeMessage.click();
		WebElement botWidget=(WebElement)jse.executeScript("return document.querySelector('df-messenger').shadowRoot.querySelector('div').querySelector('button')");		
		botWidget.click();
		Thread.sleep(3000);
		WebElement languageSelection=(WebElement)jse.executeScript("return document.querySelector('df-messenger').shadowRoot.querySelector('df-messenger-chat').shadowRoot.querySelector('df-message-list').shadowRoot.querySelector('df-chips').shadowRoot.querySelector('div').children.item(10)");
		
		/*jse.executeScript("window.scrollBy(0,1500)", "");
		 Actions a = new Actions(driver); 
		 * a.moveToElement(languageSelection, 1278, 729); 
		 */
		languageSelection.click();
		Thread.sleep(3000);	
	}

	public void framechangeZD() throws Exception {
		explicitWait("//iframe[@id='launcher']");
		Thread.sleep(5000);
		driver.switchTo().frame(iframeZD1);
		inputbox.sendKeys("Hi");
		inputbox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.switchTo().defaultContent(); 
		Thread.sleep(2000);
		driver.switchTo().frame(iframeZD2);
		Thread.sleep(2000);
	}
	
	public void framechangeMC() throws Exception {	
		botHeader.click();
		driver.switchTo().frame(mciFrame);
		}

	// To select a category
	// Replace the element you want to click
	public void categoryClick() throws Exception {
		explicitWait("(//span[@id=\"message-span\"])[1]");
		incomeTax.click();
		Category = driver.findElement(By.xpath("(//span[@id=\"message-span\"])[2]")).getText();
		System.out.println(Category);
		extent.addSystemInfo("Category", Category);
	}

	public void subCategoryClick() throws Exception {
		explicitWait("(//span[@id=\"message-span\"])[3]");
		IT_Forms.click();
		SubCategory = driver.findElement(By.xpath("(//span[@id=\"message-span\"])[4]")).getText();
		System.out.println(SubCategory);
		extent.addSystemInfo("SubCategory", SubCategory);
	}

	public void innerSubCategoryClick() throws Exception {
		explicitWait("(//span[@id=\"message-span\"])[5]");
		IT_Individual_Income_Tax.click();
		InnerSubCategory = driver.findElement(By.xpath("(//span[@id=\"message-span\"])[6]")).getText();
		System.out.println(InnerSubCategory);
		extent.addSystemInfo("InnerSubCategory", InnerSubCategory);
	}

	public void feedbackflow() throws InterruptedException {
		inputbox.sendKeys("Thanks");
		inputbox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		yesButton.click();
		Thread.sleep(3000);
		if (YesResponse.getText().contains("Okay. Please ask your question below")) {
			System.out.println("Yes Response is working fine");
		} else {
			System.out.println("Yes Response is not working fine");
		}
		inputbox.sendKeys("Thanks");
		inputbox.sendKeys(Keys.ENTER);
		noButton.click();
		Thread.sleep(5000);
		if (NoResponse.getText().contains("Great, please tap below to give feedback.")) {
			System.out.println("No Response is working fine");
		} else {
			System.out.println("No Response is not working fine");
		}
		feedbackTile.click();
		Thread.sleep(3000);

		categoryToggle.click();
		Thread.sleep(3000);
		vehicleRenewal.click();
		Thread.sleep(3000);
		if (categoryResponse.getText().contains("Great! What question about")) {
			System.out.println("Feedback Flow is working fine");
		} else {
			System.out.println("Feedback Flow is not working fine");
		}
	}
	
	public void categoryDropdown(String Sub_industries, String Platforms, String Language) throws Exception {
		Sub_industriesDropDown.click();
		driver.findElement(By.xpath("//label[@class=\"dropdown-option\"][contains(text(),'"+Sub_industries+"')]")).click();
		Sub_industriesDropDown.click();
		PlatformsDropDown.click();
		driver.findElement(By.xpath("//label[@class=\"dropdown-option\"][contains(text(),'"+Platforms+"')]")).click();
		PlatformsDropDown.click();
		LanguageDropDown.click();
		driver.findElement(By.xpath("//label[@class=\"dropdown-option\"][contains(text(),'"+Language+"')]")).click();
		LanguageDropDown.click();
		Open_VA.click();
	}
	
	public void framechangeHE() throws Exception {
		explicitWait("//iframe[@id='chatbot-iframe']");
		driver.switchTo().frame(iframeHE);
	}

	public WebElement expandRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",element);
		return ele;
	}
	
	public void openfile() throws IOException {
		Desktop.getDesktop().open(new File(prop.getProperty("SheetPath")));
	}
	
	public void dhsliveagent() throws Exception {
		explicitWait("(//span[@id='message-span'])[1]");
		inputbox.sendKeys("create account");
		inputbox.sendKeys(Keys.ENTER);
		explicitWait("(//span[@id='message-span'])[4]");
		buttonINeedHelp.click();
		explicitWait("(//span[@id='message-span'])[6]");
		buttonConnectAgent.click();
		explicitWait("(//span[@id='message-span'])[8]");
		buttonCancel.click();
	}
	
	public void calsawsLogin() throws InterruptedException {
		Thread.sleep(2000);
		csUsernamePwd.sendKeys("");
		csLogin.click();
		Thread.sleep(2000);
		csUsernamePwd.sendKeys("");
		csLogin.click();
		Thread.sleep(2000);
		csAccept.click();
		Thread.sleep(2000);
	}
	
	public void mddolButton() throws Exception {
		explicitWait("(//span[@id=\"message-span\"])[3]");
		mddolButton.click();
	}

	public void getResult(String appName) throws Exception {
		int pathindex = 3;		
		int pathindexMDDOL = 7;
		int pathindexMC = 4;
		int pathindexCALVAX = 6;
		int pathindexOVM = 3;
		int pathindexBS = 3;
		int pathindexKDOL = 6;
		int pathindexNYDOL = 6;
		int pathindexNYDOLDF = 7;
		int pathindex_HE = 2;
		int pathindexC = 5;
		int pathindexSC = 7;
		int pathindexISC = 9;
		int pathindexDorFB_C = 3;
		int pathindexDorFB_SC = 4;
		int pathindexDorFB_ISC = 5;
		m = 1;
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		for (i = k; i < excelRead.rowCount; i++) {
			 
			//BigStone
			 //explicitWait("(//span[@id=\"message-span\"])[2]");
			 //driver.navigate().refresh();
			// actualresult = "";
			 
			 //TNDHS
			 //driver.navigate().refresh();
			 //Thread.sleep(10000);
			 			 
			 //Arizona
			 //driver.navigate().refresh();
			 //explicitWait("(//div[@class='message-text'])[1]");
			 //english.click();
			
			//mddol
			//driver.navigate().refresh();
			//explicitWait("(//span[@id=\"message-span\"])[3]");
			//mddolButton.click();
			
			//HE_ServiceNow
			//driver.switchTo().defaultContent();
			//iframeClose.click();
			//Open_VA.click();
			//explicitWait("//iframe[@id='chatbot-iframe']");
			//driver.switchTo().frame(iframeHE);

			for (int j = 0; j < excelRead.colCount; j++) {
			
				if (j == 0) {

					String Usecasename = obj1[i][j].toString();
					logger = extent.startTest(Usecasename);
					excelWrite.writeExcel(m, j, Usecasename);
					System.out.println(Usecasename);

				} else if (j == 1) {
					String User_question = obj1[i][j].toString();
					if (User_question.length()>200) {
						System.out.println("Row no " + (i + 1) + " Question was too long");
						break;
					}

					System.out.println(i + "\tUser Question-- " + User_question);
					logger.log(LogStatus.INFO, i + "User Question-- ");
					logger.log(LogStatus.INFO, User_question);
					
					//HE_ServiceNow/TNDHS
					//pi = 3;
					
					//DOR_FB/HE_Kore/HE_DRUID 
					//pi = pathindex_HE;
					//pi=7;
					
					//NYDOLDF
					//pi = pathindexNYDOLDF;
					
					//Common
					//pi = pathindexSC;
					
					if(appName.equalsIgnoreCase("Missouri")) {
						pi = pathindex_HE;
					}
					
					//BFAC/AZDPS/Arizona//Ohio
					//pi = pathindex_HE;
							
					try {
						
						// Common
						if(appName.equalsIgnoreCase("Missouri")) {
						explicitWait("(//div[@class='message-text-bot'])["+(pi-1)+"]");
						inputbox.sendKeys(User_question);
						jse.executeScript("arguments[0].value = arguments[1];", inputbox, User_question);
						//inputbox.sendKeys(User_question);
						}
						
						//Ohio
						if(appName.equalsIgnoreCase("Ohio_app")) {
						explicitWait("(//div[@class='message-text'])["+(pi-1)+"]");
						inputbox.sendKeys(User_question);
						}
						
						// TNDOE/BFAC
						//explicitWait("(//p[@class='customResp-card-text'])["+(pi-1)+"]");
						//inputbox.sendKeys(User_question);
						
						//Arizona
						//explicitWait("(//div[@class='message-text'])["+(pi-1)+"]");
						//inputbox.sendKeys(User_question);
						
						//AZDPS
						//explicitWait("(//span[@class='spanText'])["+(pi-1)+"]");
						//jse.executeScript("arguments[0].value = arguments[1];", inputbox, User_question);
						
						// DOR_FB/HE_Kore/HE_DRUID
						//explicitWait("(//div[@class=\"bot-response-text\"])["+(pi-1)+"]");
						//inputbox.sendKeys(User_question);
						
						//DC FAQ
						//explicitWait("(//p[@class='lexResponse']//span)["+(pi-1)+"]");
						//inputbox.sendKeys(User_question);
						
						// TNDHS
						//WebElement inputboxtndhs=(WebElement)jse.executeScript("return document.querySelector('sn-component-va-web-client').shadowRoot.querySelector('textarea')");
						//inputboxtndhs.sendKeys(User_question);
						//inputboxtndhs.sendKeys(Keys.ENTER);
						
						//NYDOLDF
						//WebElement inputboxNYDOLDF=(WebElement)jse.executeScript("return document.querySelector('df-messenger').shadowRoot.querySelector('df-messenger-chat').shadowRoot.querySelector('df-messenger-user-input').shadowRoot.querySelector('div').children.item(1).children.item(0)");
						//inputboxNYDOLDF.sendKeys(User_question);
						//inputboxNYDOLDF.sendKeys(Keys.ENTER);												
						
						inputbox.sendKeys(Keys.ENTER);
						excelWrite.writeExcel(m, j, User_question);
					} catch (Exception e) {
						System.out.println("Input box was not visible for this user input -" + User_question);
						break;
					}

				}

				else if (j == 2) {

					String expected_result = obj1[i][j].toString();
					System.out.println("Expected Result : " + expected_result+"\n");
					logger.log(LogStatus.INFO, "Expected Result :");
					logger.log(LogStatus.INFO, expected_result);
					excelWrite.writeExcel(m, j, expected_result);

					try {

						// DORFB
						
						 /* List<WebElement> actualresultElements = driver.findElements(By.xpath(
						  "//div[@data-testid=\"messenger_incoming_text_row\"]"));
						  if(actualresultElements.size()>pi) { pathindexDorFB_C = pathindexDorFB_C+1;
						  pathindexDorFB_SC = pathindexDorFB_SC+1; pathindexDorFB_ISC =
						  pathindexDorFB_ISC+1; String actualresult1 = driver.findElement(By.xpath(
						  "(//div[@data-testid=\"messenger_incoming_text_row\"])["+pi+"]")).getText();
						  String actualresult2 = driver.findElement(By.xpath(
						  "(//div[@data-testid=\"messenger_incoming_text_row\"])["+(pi+1)+"]")).getText
						  (); actualresult= actualresult1 + actualresult2; } else { actualresult =
						  driver.findElement(By.xpath(
						  "(//div[@data-testid=\"messenger_incoming_text_row\"])["+pi+"]")).getText();
						  }*/
						 
						// Common
						if(appName.equalsIgnoreCase("Missouri")) {
						explicitWait("(//div[@class='message-text-bot'])["+pi+"]");	
						actualresult = driver.findElement(By.xpath("(//div[@class='message-text-bot'])["+pi+"]")).getText();
						}
						
						//Ohio
						if(appName.equalsIgnoreCase("Ohio_app")) {
						Thread.sleep(2500);
						explicitWait("(//div[@class='message-text'])["+pi+"]");	
						actualresult = driver.findElement(By.xpath("(//div[@class='message-text'])["+pi+"]")).getText();
						Thread.sleep(2500);
						}
						
						// TNDOE BFAC
						//explicitWait("(//p[@class='customResp-card-text'])["+(pi)+"]");
						//actualresult = driver.findElement(By.xpath("(//p[@class='customResp-card-text'])["+(pi)+"]")).getText();
						
						//Arizona
						//explicitWait("(//div[@class='message-text'])["+(pi)+"]");
						//actualresult = driver.findElement(By.xpath("(//div[@class='message-text'])["+(pi)+"]")).getText();
						
						//AZDPS
						//explicitWait("(//span[@class='spanText'])["+(pi)+"]");
						//actualresult = driver.findElement(By.xpath("(//span[@class='spanText'])["+(pi)+"]")).getText();
						
						//DC FAQ
						//explicitWait("(//p[@class='lexResponse']//span)["+pi+"]");	
						//actualresult = driver.findElement(By.xpath("(//p[@class='lexResponse']//span)["+pi+"]")).getText();
						
						
						// HE_Kore/HE_DRUID
						//explicitWait("(//div[@class=\"bot-response-text\"])["+pi+"]");	
						//actualresult = driver.findElement(By.xpath("(//div[@class=\"bot-response-text\"])["+pi+"]")).getText();
						
						//BigStone
						/*
						 * Thread.sleep(5000); List<WebElement> actualresultElements =
						 * driver.findElements(By.xpath("//span[@id=\"message-span\"]")); for(int a=3;
						 * a<=actualresultElements.size(); a++) { String actualresult1 =
						 * driver.findElement(By.xpath("(//span[@id=\"message-span\"])["+a+"]")).getText
						 * (); actualresult = actualresult.concat(actualresult1);}
						 */
						
						// TNDHS
						//Thread.sleep(12000);
						//WebElement actualresulttndhs=(WebElement)jse.executeScript("return document.querySelector('sn-component-va-web-client').shadowRoot.querySelector('sn-component-chat-window').shadowRoot.querySelectorAll('legend').item(1)");
						//actualresult = actualresulttndhs.getText();
						
						
						// NYDOLDF
						//Thread.sleep(2000);
						//WebElement actualresultNYDOLDF=(WebElement)jse.executeScript("return document.querySelector('df-messenger').shadowRoot.querySelector('df-messenger-chat').shadowRoot.querySelector('df-message-list').shadowRoot.querySelector('div').querySelectorAll('div').item(1).querySelectorAll('div').item("+pi+").children.item(0)");
						//actualresult = actualresultNYDOLDF.getText();
						
						excelWrite.writeExcel(m, 3, actualresult);
						
						//BigStone
						//WebElement cancel = driver.findElement(By.xpath("(//button[contains(.,'Cancel')])["+m+"]"));
						//cancel.click();
					}

					catch (Exception e) {
						logger.log(LogStatus.ERROR, "Error - " + e);
						System.out.println("Error - " + e);
						pathindex = pathindex + 1;
						pathindexC = pathindexC + 1;
						pathindexSC = pathindexSC + 1;
						pathindexISC = pathindexISC + 1;
						extent.flush();
						continue;
					}

					pathindex = pathindex + 2;
					pathindexKDOL = pathindexKDOL + 2;
					pathindexNYDOL = pathindexNYDOL + 2;
					pathindexNYDOLDF = pathindexNYDOLDF + 3;
					pathindexMDDOL = pathindexMDDOL + 2;
					pathindexMC = pathindexMC +2;
					pathindexCALVAX = pathindexCALVAX + 2;
					pathindexBS = pathindexBS + 4;
					pathindexOVM = pathindexOVM + 2;
					pathindex_HE = pathindex_HE + 1;
					pathindexC = pathindexC + 2;
					pathindexSC = pathindexSC + 2;
					pathindexISC = pathindexISC + 2;
					pathindexDorFB_C = pathindexDorFB_C + 1;
					pathindexDorFB_SC = pathindexDorFB_SC + 1;
					pathindexDorFB_ISC = pathindexDorFB_ISC + 1;
					System.out.println("Actaul Result : " + actualresult);
					logger.log(LogStatus.INFO, "Actual Result :");
					logger.log(LogStatus.INFO, actualresult);
					
					if (actualresult.trim().equals(expected_result.trim()))

					{

						System.out.println("Testcase Passed");
						logger.log(LogStatus.PASS, "Testcase Passed");
						excelWrite.writeExcel(m, 4, "Pass");
						System.out.println("******************");
						System.out.println("\n");

					} else {

						System.out.println("Testcase Failed");
						logger.log(LogStatus.FAIL, "Testcase Failed");
						excelWrite.writeExcel(m, 4, "Fail");
						//takescreenshot("Row"+String.valueOf(i+1));
						System.out.println("******************");
						System.out.println("\n");

					}
					extent.flush();
				}
				excelWrite.writeExcel(m, 5, String.valueOf(i+1));
			} // end of inner for loop
			//k++;
			/*
			 * if(pathindexDorFB_C>51) 
			 * { 
			 * System.out.println("coming inside break"); 
			 * break; 
			 * }
			 */
		m++;
		} // end of outer for loop
		
		//fbPathIndexCheck();
		extent.flush();	
		excelWrite.closeWorkBook();
	}

	public void fbPathIndexCheck() throws Exception {
		if(i<excelRead.rowCount) {
			fbGetStarted();
			categoryClick();
			subCategoryClick();
			//innerSubCategoryClick();
			getResult(prop.getProperty("Application"));
		}		
	}
	
	public void getReport() {
		ExtentReport extentreport = new ExtentReport(driver);
		extent=extentreport.generatereport();
	}
	public void getExcel() throws Exception {
		excelRead=new ExcelRead(driver);
		obj1=excelRead.read();
	}
	
	public void writeExcel() throws Exception {
		excelWrite=new ExcelWrite(driver);
		excelWrite.createWorkBook();
	}
	
	public void explicitWait(String xpath) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	
	public void fluentWait(String xpath) throws Exception {
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(2))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		fwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	
		
		public void takescreenshot(String rowNumber) throws Exception {
			String filePath;
			 String pattern_time = "dd-MMM-yyyy_HH-mm-ss";	 
			 SimpleDateFormat simpleDateFormat_time = new SimpleDateFormat(pattern_time);
			 String date_time = simpleDateFormat_time.format(new Date());
			 //String pattern_date = "dd-MMM-yyyy";
			 //SimpleDateFormat simpleDateFormat_date = new SimpleDateFormat(pattern_date);
			 //String date = simpleDateFormat_date.format(new Date());
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			filePath="./Report/Screenshots/"+rowNumber+"_"+date_time+".png";
			FileUtils.copyFile(source, new File(filePath));
			System.out.println("Screenshottaken");
			System.out.println("\n");	
		}
	
	public Commonfunction(WebDriver driver) {
		super();
		this.driver = driver;
	}

}
