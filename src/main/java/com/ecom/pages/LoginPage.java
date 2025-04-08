package com.ecom.pages;

import com.ecom.locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.ecom.utils.ExtentReportManager;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private LoginPageLocators locators;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.locators = new LoginPageLocators();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getEmailInput()));
        driver.findElement(locators.getEmailInput()).sendKeys(email);
        ExtentReportManager.logInfo("Entered email: " + email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getPasswordInput()));
        driver.findElement(locators.getPasswordInput()).sendKeys(password);
        ExtentReportManager.logInfo("Entered password");
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getLoginButton()));
        driver.findElement(locators.getLoginButton()).click();
        ExtentReportManager.logInfo("Clicked login button");
    }

    public boolean isLoginSuccessful() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getSuccessMessage()));
            return driver.findElement(locators.getSuccessMessage()).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginErrorDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getErrorMessage()));
            return driver.findElement(locators.getErrorMessage()).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
} 