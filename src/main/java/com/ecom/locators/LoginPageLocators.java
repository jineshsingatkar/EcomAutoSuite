package com.ecom.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
    // Login page locators for automationexercise.com
    private final By emailInput = By.xpath("//input[@data-qa='login-email']");
    private final By passwordInput = By.xpath("//input[@data-qa='login-password']");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");
    private final By successMessage = By.xpath("//a[contains(text(),'Logged in as')]");
    private final By errorMessage = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");

    public By getEmailInput() {
        return emailInput;
    }

    public By getPasswordInput() {
        return passwordInput;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getSuccessMessage() {
        return successMessage;
    }

    public By getErrorMessage() {
        return errorMessage;
    }
} 