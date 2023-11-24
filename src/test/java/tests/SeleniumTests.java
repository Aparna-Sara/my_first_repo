package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentReportsManager;

public class SeleniumTests {
	
	private WebDriver driver;
	private static ExtentReports extent;
    private static ExtentTest test;
	
	@BeforeClass
	public void setUp() {
		
		extent = ExtentReportsManager.createInstance();
        test = ExtentReportsManager.createTest(getClass().getSimpleName());

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void tearDown() {
		if(driver != null) {
		driver.quit();}
		extent.flush(); 
	}

	
	@Test
	public void testgetTitle() {
		driver.get("https://www.nets.eu/nets-nexi");
		String title = driver.getTitle();
		
		System.out.println("Title ---> "+title);
		test.pass("Test getTitle passed"); // Add a pass log to the extent report
		
	}
}
