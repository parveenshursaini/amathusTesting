package com.amathus.pages;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amathus.base.BaseClass;

public class ALoginPage extends BaseClass{
	//Page Factory - OR:
	@FindBy(xpath="//a[@class='logo']")
	WebElement logo;
	@FindBy(xpath="//a[@href='https://m2-themedemo.redboxdemo.cloud/b2c/stores/']")
	WebElement location;
	@FindBy(xpath="//a[@href='https://m2-themedemo.redboxdemo.cloud/b2c/customer/account/']")
	WebElement account;
	@FindBy(xpath="//button[@class='amathus-modal-over']")
	WebElement agepopup;
	@FindBy(xpath="//a[@href='https://m2-themedemo.redboxdemo.cloud/b2c/customer/account/create/'][1]")
	WebElement createbutton;
	@FindBy(xpath="//input[@id='firstname']")
	WebElement firstname;
	@FindBy(xpath="//input[@id='email_address']")
	WebElement lastname;
	@FindBy(xpath="//input[@id='is_subscribed']")
	WebElement subscribetick;
	@FindBy(xpath="//input[@id='email_address']")
	WebElement email;
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	@FindBy(xpath="//input[@id='password-confirmation']")
	WebElement confirmpassword;
	@FindBy(xpath="//button[@title='Create an Account']")
	WebElement submit;
	@FindBy(xpath="//div[@class='message-success success message']//div")
	WebElement confirmation;
	@FindBy(xpath="//input[@id='email'and @name='login[username]']")
	WebElement enteremail;
	@FindBy(xpath="//input[@id='pass'and @name='login[password]']")
	WebElement enterpassword;
	@FindBy(xpath="//button[@id='send2'and @class='action login primary']")
	WebElement signin;
	
	//Initializing the Page Objects:
			public ALoginPage()
			{
				PageFactory.initElements(driver, this);
			}
	//Action methods
	public String verifyTitleTest() {
		return driver.getTitle();
    }
	public boolean verifylogoTest() {
		return logo.isDisplayed();
	}
	public boolean verifylocationlink() {
		return location.isDisplayed();
	}
	public String verifyregistration() throws InterruptedException {
		account.click();
		
		Thread.sleep(3000);
		
		agepopup.click();
		  
		createbutton.click();
		
		Set<String> handles=driver.getWindowHandles();
		int n=handles.size()-1;
		System.out.println("number of popups = "+n);
		if(n==0)
		{
			firstname.sendKeys("John");
			lastname.sendKeys("deer");
			subscribetick.click();
			email.sendKeys("efasozette-3293@yopmail.com");
			password.sendKeys("Test@12345");
			confirmpassword.sendKeys("Test@12345");
		    submit.click();
			
		}
		return confirmation.getText();
	}
		public AHomePage verifylogin(String uname,String pass) {
			account.click();
			enteremail.sendKeys(uname);
			enterpassword.sendKeys(pass);
			signin.click();
			return new AHomePage();
			
			
		
	}
}
