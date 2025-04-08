package com.ecom.base;

import com.ecom.utils.ConfigReader;
import com.ecom.utils.ExtentReportManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected static final String BASE_URL = ConfigReader.getProperty("base.url");

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        logger.info("Setting up WebDriver for browser: " + browser);
        
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(BASE_URL);
        
        ExtentReportManager.createTest(getClass().getSimpleName());
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Closing WebDriver");
        if (driver != null) {
            driver.quit();
        }
        ExtentReportManager.flushReport();
    }
} 