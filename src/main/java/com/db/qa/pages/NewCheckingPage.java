package com.db.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.db.qa.base.TestBase;

public class NewCheckingPage extends TestBase{

	@FindBy(xpath = "//div[@class='card-header bg-flat-color-1']/strong")
	WebElement text;
	
	@FindBy(xpath = "//input[@id='Standard Checking']")
	WebElement standCheckingAccountType;
	
	@FindBy(xpath = "//input[@id='Individual']")
	WebElement accountOwnerShip;
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement accountName;
	
	@FindBy(xpath = "//input[@id='openingBalance']")
	WebElement depositeAmount;
	
	@FindBy(xpath = "//button[@type='submit' and @class='btn btn-primary btn-sm']")
	WebElement submitButton;
	
	public NewCheckingPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public String validateNewCheckingPageURL() {
		return driver.getCurrentUrl();	
	}
	
	public String validateTheText() {
		return text.getText();
	}

	public ViewCheckingPage addNewCheckingAccount(String aName, String dAmount) throws IOException {
		standCheckingAccountType.click();
		accountOwnerShip.click();
		
		accountName.clear();
		accountName.sendKeys(aName);
		
		depositeAmount.clear();
		depositeAmount.sendKeys(dAmount);
		
		submitButton.click();
		
		return new ViewCheckingPage();
	}
}