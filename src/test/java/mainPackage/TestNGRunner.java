package mainPackage;

import java.util.Collections;
import org.testng.TestNG;


public class TestNGRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.setTestSuites(Collections.singletonList("./testng.xml"));
        testNG.run();
    }
}