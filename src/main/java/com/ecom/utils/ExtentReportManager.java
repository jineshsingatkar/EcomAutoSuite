package com.ecom.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    private static final Logger logger = LogManager.getLogger(ExtentReportManager.class);
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initReport() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportPath = "src/main/resources/reports/extent-report-" + timeStamp + ".html";
        
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setDocumentTitle("E-commerce Automation Test Report");
        spark.config().setReportName("Test Execution Report");
        
        extent = new ExtentReports();
        extent.attachReporter(spark);
        
        logger.info("Extent Report initialized at: " + reportPath);
    }

    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void logInfo(String message) {
        test.info(message);
        logger.info(message);
    }

    public static void logPass(String message) {
        test.pass(message);
        logger.info("PASS: " + message);
    }

    public static void logFail(String message) {
        test.fail(message);
        logger.error("FAIL: " + message);
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
            logger.info("Extent Report flushed");
        }
    }
} 