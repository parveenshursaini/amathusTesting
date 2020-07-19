import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
public class TestAmathus {
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		driver.get("https://redboxadmin:UnckrgUjLcvpDc3@m2-themedemo.redboxdemo.cloud/b2c/");		
	}
	@Test
	public void verifyTitleTest() {
		String title=driver.getTitle();
		AssertJUnit.assertEquals(title, "Amathus Home");
	}
	@Test
	public void verifylogoTest() {
		WebElement logo=driver.findElement(By.xpath("//a[@class='logo']"));
		Assert.assertEquals(logo.isDisplayed(), true);
	}
	@Test
	public void verifylocationlink() {
		
		WebElement location=driver.findElement(By.xpath("//a[@href='https://m2-themedemo.redboxdemo.cloud/b2c/stores/']"));
		Assert.assertEquals(location.isDisplayed(), true);
	}
	@Test
	public void verifyregistration() {
		driver.findElement(By.xpath("//a[@href='https://m2-themedemo.redboxdemo.cloud/b2c/customer/account/']")).click();
		Set handles=driver.getWindowHandles();
		int n=handles.size()-1;
		System.out.println("number of popups = "+n);
		if(n==0) {
			driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("John");
			driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("deer");
			driver.findElement(By.xpath("//input[@id='is_subscribed']")).click();
			
			
			driver.findElement(By.xpath("i//nput[@id='mail_address']")).sendKeys("zammetosari-8147@yopmail.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("test123");
			driver.findElement(By.xpath("//input[@id='password-confirmation']")).sendKeys("test123");
			driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
			
			
		}
			
			
		
	}
		
	
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
		
	}
	
	
	
	
	

}


