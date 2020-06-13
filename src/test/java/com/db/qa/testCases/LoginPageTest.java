package com.db.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.db.qa.base.TestBase;
import com.db.qa.pages.HomePage;
import com.db.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initalization();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(priority = 1)
	public void validatePageURL() {
		String url = loginPage.validateLoginPageURL();
		Assert.assertEquals("http://dbankdemo.com/login", url);
	}
	
	@Test(priority = 2)
	public void validatePageTitle() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals("Digital Bank", title);
	}
	
	@Test(priority = 3)
	public void loginTest() throws IOException, InterruptedException {
		homePage =  loginPage.loginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
	}

}
