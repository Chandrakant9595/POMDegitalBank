package com.db.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.db.qa.base.TestBase;
import com.db.qa.util.TestUtil;

public class ViewCheckingPage extends TestBase{

	@FindBy(xpath = "//table[@id='transactionTable']/tbody/tr[@class='odd']/td[5]")
	WebElement totalBalance;
	
	public ViewCheckingPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public String verifyBalceAmount() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals("http://dbankdemo.com/account/checking-view?selectSwitch=18583", url);
		TestUtil.scrollPage();
		return totalBalance.getText();
	}
}
