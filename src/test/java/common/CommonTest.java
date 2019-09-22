package common;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ukr.sinoptik.report.GenerateExtentReport;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class CommonTest {

    protected WebDriver driver;
    protected ExtentReports extentReports = GenerateExtentReport.getReportInstance(RandomStringUtils.randomAlphabetic(5));
    public ExtentTest extentTestLogger;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    @AfterSuite
    public void releasesResources() {
        driver.quit();
    }

    @AfterMethod
    public void getResult(ITestResult result, Method method, ITestContext context) {
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTestLogger.log(LogStatus.FAIL, result.getName() + " Test Failed! Please find details bellow:");
            extentTestLogger.log(LogStatus.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTestLogger.log(LogStatus.SKIP, result.getName() + " Test was skipped!");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTestLogger.log(LogStatus.PASS, result.getName() + " Test passed!");
        } else {
            extentTestLogger.log(LogStatus.INFO, "Test result = " + result.getStatus());
        }
        extentReports.endTest(extentTestLogger);
    }

    @AfterSuite
    public void close() {
        extentReports.flush();
        extentReports.close();
    }
}
