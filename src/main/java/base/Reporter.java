package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Reporter {
    ExtentSparkReporter sparkReporter;
    ExtentReports report;
    ExtentTest test;
    public ExtentTest startTestReport(String name){
        report = new ExtentReports();
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/"+name);
        report.attachReporter(sparkReporter);
        test = report.createTest(name);
        return test;
    }
    public int generateRandomNumber(){
        Random random = new Random();
        int number = random.nextInt(2000);
        return number;
    }
    public static String getScreenShot(WebDriver driver) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File finalDestination = new File(System.getProperty("user.dir")+"/Reports/ScreenShots/image"+date+".jpg");
        FileUtils.copyFile(source,finalDestination);
        return finalDestination.getAbsolutePath();
    }
    public void reportSteps(ITestResult result, WebDriver driver) throws IOException {
        if(result.getStatus() == ITestResult.SUCCESS){
            test.log(Status.PASS, "Passed: "+result.getName());
            String screenPath = Reporter.getScreenShot(driver);
            test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(screenPath).build());
        }
    }
    public void flushReport(){
        report.flush();
    }



}
