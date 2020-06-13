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
import com.db.qa.pages.NewCheckingPage;
import com.db.qa.util.TestUtil;

public class NewCheckingPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	NewCheckingPage newCheckingPage;
		
	String sheetName = "NewCheckingAccount";
	
	public NewCheckingPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initalization();
		loginPage = new LoginPage();
		homePage = loginPage.loginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		newCheckingPage = homePage.clickOnNewCheckingLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void validateNewCheckingPageURL() {
		String url = newCheckingPage.validateNewCheckingPageURL();
		Assert.assertEquals("http://dbankdemo.com/account/checking-add", url);
	}
	
	@Test(priority = 2)
	public void validateTheText() {
		String text = newCheckingPage.validateTheText();
		Assert.assertEquals("New Checking Account", text);
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() throws InvalidFormatException {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 3, dataProvider="getDataFromExcel")
	public void addNewChecking(String an, String da) throws IOException {
		newCheckingPage.addNewCheckingAccount(an, da);
	}
}
