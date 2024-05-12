package io.github.nkacc.mvnp.tryextentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TryExtentReport {

    private ExtentReports extent;

    @BeforeTest
    public void setUp() throws IOException {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("target/extent.html");
        final File CONFIG_FILE = new File("src/test/resources/config/extentreports/html-config.xml");
        htmlReporter.loadXMLConfig(CONFIG_FILE);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test
    public void test1() throws IOException {
        ExtentTest test = extent.createTest("Test1", "This is Test1");
        test.assignCategory("Category1");

        // Log test steps
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.pass("This test passed");
    }

    @Test
    public void extendTest() throws IOException {
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
        test.assignCategory("Category1", "Category2");

        // Log test steps
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(
                "C:\\Users\\naveen.s.r\\OneDrive - Accenture\\Pictures\\Screenshots\\Screenshot (300).png"//"screenshot.png"
        ).build());
        test.addScreenCaptureFromPath("screenshot.png");
    }

    @Test
    public void test3() throws IOException {
        ExtentTest test = extent.createTest("Test3", "This is Test3");
        test.assignCategory("Category3");

        // Log test steps
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.skip("This test was skipped");
    }

    @AfterTest
    public void tearDown() {
        extent.flush();
    }
}