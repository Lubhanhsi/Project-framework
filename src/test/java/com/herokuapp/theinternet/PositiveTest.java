package com.herokuapp.theinternet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTest {

    @Test
    public void loginTest() throws InterruptedException{

        System.out.println("Starting login test");

        //Create a driver
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver");
        WebDriver driver= new ChromeDriver();

        //Maximize window
        driver.manage().window().maximize();

        //Open the test page
        String url="https://the-internet.herokuapp.com/";
        driver.get(url);
        System.out.println("page opened");
        Thread.sleep(3000);
        WebElement fAuth= driver.findElement(By.xpath("//a[text()='Form Authentication']"));
        fAuth.click();
        //Enter username
        Thread.sleep(2000);
        WebElement username= driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
        //Enter Password
        Thread.sleep(2000);
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        //Click login button
        Thread.sleep(2000);
        WebElement loginBtn= driver.findElement(By.tagName("button"));
        loginBtn.click();

        //Successful login message
        Thread.sleep(2000);
        WebElement successMsg= driver.findElement(By.xpath("//div[@id='flash']"));
        String expectedText="You logged into a secure area!";
        String actual=successMsg.getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains(expectedText),
                "Actual message does not contain expected message.\nActual Message: " + actual
                        + "\nExpected Message: " + expectedText);
        //Verifications
        String expectedUrl="https://the-internet.herokuapp.com/secure";
        String actualUrl=driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(actualUrl,expectedUrl);

        //New url
        //Logout button is visible
        Thread.sleep(2000);
        WebElement logoutBtn= driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        Assert.assertTrue(logoutBtn.isDisplayed(),"Logout button is not visible");
        logoutBtn.click();

        //Close driver
        driver.quit();

        System.out.println("driver closed");
    }
}

