package com.db.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.db.qa.base.TestBase;
import com.db.qa.pages.HomePage;
import com.db.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

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
	
	
	@Test(priority = 1, description = "Validate the login page URL test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Allure: Validate the login page URL")
	public void validatePageURL() {
		String url = loginPage.validateLoginPageURL();
		Assert.assertEquals("http://dbankdemo.com/login", url);
	}
	
	@Test(priority = 2, description = "Validate the login page title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Allure: Validate the login page title")
	public void validatePageTitle() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals("Digital Bank", title);
	}
	
	@Test(priority = 3, description = "Validate the login functionality")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Allure: Validate the login functionality")
	public void loginTest() throws IOException, InterruptedException {
		homePage =  loginPage.loginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
	}

}
