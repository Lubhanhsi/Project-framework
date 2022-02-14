package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class BaseTest extends Reporter{
    protected WebDriver driver;
    protected ExtentTest test;
    ExtentReports report;
    @BeforeMethod(alwaysRun = true)
    protected void setUp(){
        ChromeDriverFactory chFactory= new ChromeDriverFactory();
        driver=chFactory.createChromeBrowser();
        test = startTestReport();
    }
    @AfterMethod(alwaysRun = true)
    protected void tearDown(ITestResult result) throws IOException {
        driver.quit();
        test.log(Status.INFO, "Test case passed is"+  result.getName());
        String screenShotPath = Reporter.getScreenShot(driver, result.getName());
        test.log(Status.INFO, (Markup) test.addScreenCaptureFromPath(screenShotPath));
        flushReport();
        System.out.println("driver closed");
    }

    @DataProvider
    public Iterator<Object[]> fetchDataFromSheet() {
        ArrayList<String> list = new ArrayList<>();
        try {
            Fillo fillo = new Fillo();
            Connection connection = fillo.getConnection("./TestData.xlsx");
            Recordset recordset = connection.executeQuery("SELECT * FROM Login");
            while (recordset.next()) {
                System.out.println(recordset.getField("URL"));
                list.add(recordset.getField("URL"));
            }
            System.out.println(list);

        } catch (FilloException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (Iterator<Object[]>) list;
    }
}
