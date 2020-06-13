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
	
	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public NewCheckingPage clickOnNewCheckingLink() throws IOException {
		checkingLink.click();
		newCheckingLink.click();
		return new NewCheckingPage();
	}
}

