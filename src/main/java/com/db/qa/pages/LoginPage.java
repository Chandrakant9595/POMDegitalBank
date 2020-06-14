package com.db.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.db.qa.base.TestBase;

import io.qameta.allure.Step;

public class LoginPage extends TestBase{

	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@id='submit']")
	WebElement signInButton;

	
	
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	@Step("Getting login page URL step...")
	public String validateLoginPageURL() {
		return driver.getCurrentUrl();	
	}
	
	@Step("Getting login page title step...")
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	@Step("Login with username: {0} and password: {1} step...")
	public HomePage loginFunctionality(String un, String pass) throws IOException {
		userName.clear();
		userName.sendKeys(un);
		
		password.clear();
		password.sendKeys(pass);
		
		signInButton.click();
		 
		return new HomePage();
	}
}
