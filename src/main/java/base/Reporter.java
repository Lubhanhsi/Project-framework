package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Reporter {
    WebDriver driver;
    ExtentSparkReporter sparkReporter;
    ExtentReports report;
    ExtentTest test;
    public ExtentTest startTestReport(){
        report = new ExtentReports();
        sparkReporter = new ExtentSparkReporter("./Reports/Testcasename"+generateRandomNumber());
        report.attachReporter(sparkReporter);
        test = report.createTest("Testcasename");
        return test;
    }
    public int generateRandomNumber(){
        Random random = new Random();
        int number = random.nextInt(2000);
        return number;
    }
    public static String getScreenShot(WebDriver driver, String name) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("./ScreenShots"+date+".png");
        File finalDestination = new File(destination);
        FileUtils.copyFile(source,finalDestination);
        return destination;
    }
    public void flushReport(){
        report.flush();
    }



}
