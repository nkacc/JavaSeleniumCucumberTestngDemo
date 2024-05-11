package io.github.nkacc.mvnp.tryextentreport;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;

import java.io.File;
import java.io.IOException;

public class TryExtentReport {

    @Test
    public void extendTest() throws IOException {
        ExtentReports extend = new ExtentReports();
        ExtentSparkReporter ehtml = new ExtentSparkReporter("target/extent.html");

        final File CONFIG_FILE = new File("src/test/resources/config/extentreports/html-config.xml");
        ehtml.loadXMLConfig(CONFIG_FILE);
        extend.attachReporter(ehtml);

        ExtentTest test = extend.createTest("MyFirstTest");
        test.pass("Details");

        extend.flush();
    }

}
