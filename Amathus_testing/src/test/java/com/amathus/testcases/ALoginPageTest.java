package com.amathus.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.amathus.base.BaseClass;
import com.amathus.pages.AHomePage;
import com.amathus.pages.ALoginPage;

public class ALoginPageTest extends BaseClass {
	
	ALoginPage loginpage;
	AHomePage homepage;
	
	public ALoginPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initialization();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginpage.verifyTitleTest();
		Assert.assertEquals(title, "Amathus Home");
	}
	
	@Test(priority=2)
	public void logoTest(){
		boolean flag = loginpage.verifylogoTest();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void locationTest(){
		boolean flag= loginpage.verifylocationlink();
		Assert.assertTrue(flag);
	}
	@Test(priority=4)
	public void registrationTest() {
		String text = null;
		try {
			text = loginpage.verifyregistration();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(text, "Thank you for registering with Amathus.");
	}
		
    @Test(priority=5)
    public void loginTest(){
			homepage = loginpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
}
	
	
