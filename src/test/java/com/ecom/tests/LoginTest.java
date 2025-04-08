package com.ecom.tests;

import com.ecom.base.BaseTest;
import com.ecom.pages.LoginPage;
import com.ecom.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    
    @Test(description = "Verify successful login with valid credentials")
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        
        // Test data
        String email = "test@example.com";
        String password = "password123";
        
        // Perform login
        loginPage.login(email, password);
        
        // Verify login success
        boolean isLoginSuccessful = loginPage.isLoginSuccessful();
        Assert.assertTrue(isLoginSuccessful, "Login was not successful");
        ExtentReportManager.logPass("Login test completed successfully");
    }
    
    @Test(description = "Verify login fails with invalid credentials")
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        
        // Test data with invalid credentials
        String email = "invalid@example.com";
        String password = "wrongpassword";
        
        // Perform login
        loginPage.login(email, password);
        
        // Verify login failure
        boolean isLoginSuccessful = loginPage.isLoginSuccessful();
        Assert.assertFalse(isLoginSuccessful, "Login should have failed with invalid credentials");
        ExtentReportManager.logPass("Invalid login test completed successfully");
    }
} 