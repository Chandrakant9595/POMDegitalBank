package com.db.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.db.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = "//a[text()='Checking']")
	WebElement checkingLink;
	
	@FindBy(xpath = "//a[text()='New Checking']")
	WebElement newCheckingLink;
	
	@FindBy(xpath = "//a[text()='Savings']")
	WebElement savingsLink;
	
	@FindBy(xpath = "//a[text()='New Savings']")
	WebElement newSavingsLink;
	
	@FindBy(xpath = "//a[text()='Transactions']")
	WebElement transactionsLink;
	
	@FindBy(xpath = "//a[text()='Deposit']")
	WebElement depositLink;
	
	@FindBy(xpath = "//a[text()='Withdraw']")
	WebElement withdrawtLink;
	
	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public NewCheckingPage clickOnNewCheckingLink() throws IOException {
		checkingLink.click();
		newCheckingLink.click();
		return new NewCheckingPage();
	}
	
	public NewSavingAccountPage clickOnNewSavingLink() throws IOException {
		savingsLink.click();
		newSavingsLink.click();
		return new NewSavingAccountPage();
	}

	public DepositPage clickOnDepositLink() throws IOException {
		transactionsLink.click();
		depositLink.click();
		return new DepositPage();
	}
	
	public WithdrawPage clickOnWithdrawLink() throws IOException {
		transactionsLink.click();
		withdrawtLink.click();
		return new WithdrawPage();
	}
}