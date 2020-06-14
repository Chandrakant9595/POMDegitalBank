package com.db.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.db.qa.base.TestBase;
import com.db.qa.pages.HomePage;
import com.db.qa.pages.LoginPage;
import com.db.qa.pages.ViewCheckingPage;
import com.db.qa.pages.WithdrawPage;

public class WithdrawPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	WithdrawPage withdrawPage;
	ViewCheckingPage viewCheckingPage;
	
	public WithdrawPageTest() throws IOException {
		super();		
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initalization();
		loginPage = new LoginPage();
		homePage = loginPage.loginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		withdrawPage = homePage.clickOnWithdrawLink();
		viewCheckingPage = new ViewCheckingPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void withdrawPageURLTest() {
		String url = withdrawPage.verifyWithdrawURL();
		Assert.assertEquals("http://dbankdemo.com/account/withdraw", url);
	}
	
	@Test(priority = 2)
	public void verifyTextOnWithdwarPageTest() {
		String text = withdrawPage.verifyTextOnWithdwarPage();
		Assert.assertEquals("Withdraw from Account", text);
	}
	
	@Test(priority = 3)
	public void verifyWithdrawFromAccountTest() throws IOException {
		withdrawPage.withdrawFromAccount();
		String balance = viewCheckingPage.verifyBalceAmount();
		Assert.assertEquals("$500.00", balance);
	}
}
