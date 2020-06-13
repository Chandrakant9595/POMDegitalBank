package com.db.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.db.qa.base.TestBase;

public class NewSavingAccountPage extends TestBase{

	@FindBy(xpath = "//strong[text()='New Savings Account']")
	WebElement text;
	
	@FindBy(xpath = "//input[@id='Money Market']")
	WebElement checkingAccountType;
	
	@FindBy(xpath = "//input[@id='Joint']")
	WebElement accountOwnership;
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement accountName;
	
	@FindBy(xpath = "//input[@id='openingBalance']")
	WebElement initialDeposit;
	
	@FindBy(xpath = "//button[@id='newSavingsSubmit']")
	WebElement submitButton;
	
	public NewSavingAccountPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public String verifyNewSavingPageURL() {
		return driver.getCurrentUrl();
	}
	
	public String verifyText() {
		return text.getText();
	}
	
	public ViewSavingAccountPage addSavingAccount(String aName, String iDeposit) throws IOException {
		checkingAccountType.click();
		accountOwnership.click();
		
		accountName.clear();
		accountName.sendKeys(aName);
		initialDeposit.clear();
		initialDeposit.sendKeys(iDeposit);
		
		submitButton.click();
		
		return new ViewSavingAccountPage();
	}
}