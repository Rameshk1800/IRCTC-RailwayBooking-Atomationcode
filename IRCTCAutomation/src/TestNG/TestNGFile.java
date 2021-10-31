package TestNG;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGFile {
	
	WebDriver driver;
	
	
	@BeforeSuite
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");

		ChromeOptions option =new ChromeOptions();
		option.addArguments("disable-notifications");


		 driver = new ChromeDriver(option);


		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
	}
	

	@Test
	public void testCases() throws IOException {
		
		WebElement alertbox= driver.findElement(By.xpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button"));	
		alertbox.click();
		
		WebElement fromBox = driver.findElement(By.xpath("//*[@id=\'origin\']/span/input"));
		fromBox.sendKeys("CHENNAI EGMORE - MS");
		
		WebElement toBox = driver.findElement(By.xpath("//*[@id=\'destination\']/span/input"));
		toBox.sendKeys("TENKASI JN - TSI");
		
		WebElement general = driver.findElement(By.xpath("//*[@id=\'journeyQuota\']/div"));
		general.click();

		WebElement generlToGive = driver.findElement(By.xpath("//*[@id=\'journeyQuota\']/div/div[4]/div/ul/p-dropdownitem[1]/li"));
		generlToGive.click();
		
		WebElement date = driver.findElement(By.xpath("//*[@id=\'jDate\']/span/input"));
		date.click();
		
		WebElement dateToGo= driver.findElement(By.xpath("//*[@id=\'jDate\']/span/div/div/div[1]/a[2]"));
		dateToGo.click();
		
		WebElement dateToGive = driver.findElement(By.xpath("//*[@id=\'jDate\']/span/div/div/div[2]/table/tbody/tr[2]/td[6]/a"));
		dateToGive.click();
		
		WebElement classBox = driver.findElement(By.xpath("//*[@id=\'journeyClass\']/div"));
		classBox.click();
		
		WebElement classToGive = driver.findElement(By.xpath("//*[@id=\'journeyClass\']/div/div[4]/div/ul/p-dropdownitem[10]/li"));
		classToGive.click();
		
		WebElement searchBox = driver.findElement(By.xpath("//*[@id=\'divMain\']/div/app-main-page/div/div/div[1]/div[1]/div[1]/app-jp-input/div/form/div[5]/div/button"));
		searchBox.click();
		
		
	   TakesScreenshot screenshot = (TakesScreenshot) driver;
	   File SourceFile= screenshot.getScreenshotAs(OutputType.FILE);
	   File destinationFile= new File("E://Sample.png");
	   FileHandler.copy(SourceFile, destinationFile);
	   
	   
	}
	
	@AfterSuite
	public void Quit () {
		driver.quit();
		
	}
	
}
