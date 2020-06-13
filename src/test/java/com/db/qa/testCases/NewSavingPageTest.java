package com.db.qa.testCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.db.qa.base.TestBase;
import com.db.qa.pages.HomePage;
import com.db.qa.pages.LoginPage;
import com.db.qa.pages.NewSavingAccountPage;
import com.db.qa.util.TestUtil;

public class NewSavingPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	NewSavingAccountPage newSavingAccountPage;
	
	String sheetName = "NewSavingAccount";
	
	public NewSavingPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initalization();
		loginPage = new LoginPage();
		homePage = loginPage.loginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		newSavingAccountPage = homePage.clickOnNewSavingLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyNewSavingAccountURL() {
		String url = newSavingAccountPage.verifyNewSavingPageURL();
		Assert.assertEquals("http://dbankdemo.com/account/savings-add", url);
	}
	
	@Test(priority = 2)
	public void verifyTextOnNewSavingAccountPage() {
		String text = newSavingAccountPage.verifyText();
		Assert.assertEquals("New Savings Account", text);
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() throws InvalidFormatException {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 3, dataProvider="getDataFromExcel")
	public void addSavingAccountTest(String an, String id) throws IOException {
		newSavingAccountPage.addSavingAccount(an, id);
	}
}