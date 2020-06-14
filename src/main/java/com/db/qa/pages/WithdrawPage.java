package com.db.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.db.qa.base.TestBase;

public class WithdrawPage extends TestBase{

	@FindBy(xpath = "//strong[text()='Withdraw from Account']")
	WebElement text;
	
	@FindBy(xpath = "//div[@class='col col-sm-4']/select[@id='id']")
	WebElement accountFromWithdwarDropDown;
	
	@FindBy(xpath = "//div[@class='col col-sm-4']/input[@name='amount']")
	WebElement withdrawAmount;
	
	@FindBy(xpath = "//div[@class='card-footer']/button[@type='submit']")
	WebElement submitButton;
	
	public WithdrawPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public String verifyWithdrawURL() {
		return driver.getCurrentUrl();
	}

	public String verifyTextOnWithdwarPage() {
		return text.getText();
	}

	public ViewCheckingPage withdrawFromAccount() throws IOException {
		Select dropDown = new Select(accountFromWithdwarDropDown);
		dropDown.selectByVisibleText("Vicky  -  (Standard Checking)  -  ($600.00)");
		
		withdrawAmount.clear();
		withdrawAmount.sendKeys("100");
		
		submitButton.click();
		
		return new ViewCheckingPage();
	}
}