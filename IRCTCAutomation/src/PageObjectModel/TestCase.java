package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestCase {
	
	
	WebDriver driver;
	
	@Test
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");

		ChromeOptions option =new ChromeOptions();
		option.addArguments("disable-notifications");


		 driver = new ChromeDriver(option);


		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		
		PageFactory.initElements(driver, RailwayPOM.class);
		
		RailwayPOM railwayPOM = new RailwayPOM();
		
		
		
		RailwayPOM.alertbox.click();
		RailwayPOM.fromBox.sendKeys("CHENNAI EGMORE - MS");
		RailwayPOM.toBox.sendKeys("TENKASI JN - TSI");
		RailwayPOM.general.click();
		RailwayPOM.generlToGive.click();
		RailwayPOM.date.click();
		RailwayPOM.dateToGo.click();
		RailwayPOM.dateToGive.click();
		RailwayPOM.classBox.click();
		RailwayPOM.classToGive.click();
		RailwayPOM.searchBox.click();
		
		
		
		
		
	}

	
}
