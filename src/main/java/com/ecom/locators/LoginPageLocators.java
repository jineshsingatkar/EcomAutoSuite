package com.ecom.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
    // Login page locators
    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.xpath("//button[contains(text(),'Login')]");
    private final By successMessage = By.xpath("//div[contains(@class,'alert-success')]");

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
} 