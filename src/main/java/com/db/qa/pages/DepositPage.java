package com.db.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.db.qa.base.TestBase;

public class DepositPage extends TestBase{

	@FindBy(xpath = "//strong[text()='Deposit into Account']")
	WebElement text;
	
	@FindBy(xpath = "//div[@class='col col-sm-4']/select[@id='id']")
	WebElement accountForDeposit;
	
	@FindBy(xpath = "//div[@class='col col-sm-4']/input[@name='amount']")
	WebElement depositAmount;
	
	@FindBy(xpath = "//div[@class='card-footer']/button[@type='submit']")
	WebElement submitButton;
	
	public DepositPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public String verifyDepositURL() {
		return driver.getCurrentUrl();
	}

	public String verifyText() {
		return text.getText();
	}
	
	public ViewCheckingPage depositAmmountInToAccount() throws IOException {
		Select dropDown = new Select(accountForDeposit);
		dropDown.selectByVisibleText("Vicky  -  (Standard Checking)  -  ($500.00)");
		
		depositAmount.clear();
		depositAmount.sendKeys("100");
		
		submitButton.click();
		
		return new ViewCheckingPage();
	}
}