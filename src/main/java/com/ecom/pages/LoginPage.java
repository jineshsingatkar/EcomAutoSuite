package com.ecom.pages;

import com.ecom.locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.ecom.utils.ExtentReportManager;

public class LoginPage {
    private WebDriver driver;
    private LoginPageLocators locators;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.locators = new LoginPageLocators();
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        driver.findElement(locators.getEmailInput()).sendKeys(email);
        ExtentReportManager.logInfo("Entered email: " + email);
    }

    public void enterPassword(String password) {
        driver.findElement(locators.getPasswordInput()).sendKeys(password);
        ExtentReportManager.logInfo("Entered password");
    }

    public void clickLoginButton() {
        driver.findElement(locators.getLoginButton()).click();
        ExtentReportManager.logInfo("Clicked login button");
    }

    public boolean isLoginSuccessful() {
        boolean isSuccess = driver.findElement(locators.getSuccessMessage()).isDisplayed();
        ExtentReportManager.logInfo("Login success status: " + isSuccess);
        return isSuccess;
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
} 