package Test.OrangeHRM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;



public class BaseClass {
	WebDriver driver;

	@BeforeMethod
	
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown() {

	    if (driver != null) {
	        driver.quit();
	    }
	}
}
