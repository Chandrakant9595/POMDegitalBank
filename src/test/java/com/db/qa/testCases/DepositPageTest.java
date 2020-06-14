package com.db.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.db.qa.base.TestBase;
import com.db.qa.pages.DepositPage;
import com.db.qa.pages.HomePage;
import com.db.qa.pages.LoginPage;
import com.db.qa.pages.ViewCheckingPage;

public class DepositPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	DepositPage depositPage;
	ViewCheckingPage viewCheckingPage;
	
	public DepositPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initalization();
		loginPage = new LoginPage();
		homePage =loginPage.loginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		depositPage = homePage.clickOnDepositLink();
		viewCheckingPage = new ViewCheckingPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifyDepositURLTest() {
		String url = depositPage.verifyDepositURL();
		Assert.assertEquals("http://dbankdemo.com/account/deposit", url);
	}

	@Test(priority = 2)
	public void verifyTextTest() {
		String text = depositPage.verifyText();
		Assert.assertEquals("Deposit into Account", text);
	}
	
	@Test(priority = 3)
	public void addDepositInToAccount() throws IOException {
		depositPage.depositAmmountInToAccount();
		String balance = viewCheckingPage.verifyBalceAmount();
		Assert.assertEquals("$600.00", balance);
	}
}
