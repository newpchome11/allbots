package accessibility;

import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.deque.axe.AXE;

public class accessibilityTest{
	private static final URL scriptURL = accessibilityTest.class.getClassLoader().getResource("axe.min.js");
	
	public void a11y(WebDriver driver) throws Exception {
	System.out.println("URL: " +scriptURL);
	
	JSONObject responseJson = new AXE.Builder(driver, scriptURL).analyze();
	JSONArray violations = responseJson.getJSONArray("violations");
	
	if(violations.length()==0) {
		Assert.assertTrue(true, "No errors");
	}
	else {		
	AXE.writeResults("accessibilityTest", responseJson);
	Assert.assertTrue(false, AXE.report(violations));
	}
	
	}
}