package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTests {
	
	private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void tearDown() {
		if(driver != null) {
		driver.quit();}
	}

	
	@Test
	public void testgetTitle() {
		driver.get("https://www.nets.eu/nets-nexi");
		String title = driver.getTitle();
		
		System.out.println("Title ---> "+title);
		
	}
}
