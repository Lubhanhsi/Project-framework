package com.herokuapp.theinternet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeTest {
    private WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    private void setUp(){

        //Create a driver
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver");
        driver= new ChromeDriver();

        //Maximize window
        driver.manage().window().maximize();
    }
    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 1, enabled = true)
    private void loginFailWrongPassword(String uname, String pswd, String message) throws InterruptedException{

        //Open the test page
        String url="https://the-internet.herokuapp.com/";
        driver.get(url);
        System.out.println("page opened");
        Thread.sleep(500);
        WebElement fAuth= driver.findElement(By.xpath("//a[text()='Form Authentication']"));
        fAuth.click();
        Thread.sleep(500);
        //Enter username
        WebElement username= driver.findElement(By.id("username"));
        username.sendKeys(uname);
        //Enter Password
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys(pswd);
        //Click login button
        WebElement loginBtn= driver.findElement(By.tagName("button"));
        loginBtn.click();

        //error login message
        Thread.sleep(500);
        WebElement errorMsg= driver.findElement(By.xpath("//div[@id='flash']"));
        String actual=errorMsg.getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains(message),
                "Actual message does not contain expected message.\nActual Message: " + actual
                        + "\nExpected Message: " + message);


    }
   @AfterMethod(alwaysRun = true)
    private void tearDown(){
       //Close driver
       driver.quit();

       System.out.println("driver closed");
   }
}

