package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BaseMethods {
    WebDriver driver;
    public BaseMethods(WebDriver driver){
        this.driver=driver;
    }
    public void openURL(String url){
        driver.get(url);
    }
    public void clickByXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }
    public void enterByXpath(String xpath, String value){
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }
    public void clickById(String id){
        driver.findElement(By.id(id)).click();
    }
    public void enterById(String id, String value){
        driver.findElement(By.id(id)).sendKeys(value);
    }
    public void clickByTagName(String tag){
        driver.findElement(By.tagName(tag)).click();
    }
    public void enterByTagName(String tagName, String value){
        driver.findElement(By.tagName(tagName)).sendKeys(value);
    }
    public void compareTextByXpath(String xpath, String expectedText){
        String actual=driver.findElement(By.xpath(xpath)).getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains(expectedText),
                "Actual message does not contain expected message.\nActual Message: " + actual
                        + "\nExpected Message: " + expectedText);

    }

}
