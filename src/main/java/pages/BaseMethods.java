package pages;

import base.Reporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.Set;

public class BaseMethods extends Reporter {
    WebDriver driver;
    ExtentTest test;
    public BaseMethods(WebDriver driver, ExtentTest test){
        this.driver=driver;
        this.test = test;
    }
    public void openURL(String url){
        driver.get(url);
        System.out.println(url+" opened");
    }
    public void navigateBackFromCurrentPage() throws InterruptedException {
        Thread.sleep(500);
        driver.navigate().back();
        test.log(Status.PASS,"Back to previous page");
        System.out.println("Back to previous page");
        Thread.sleep(500);
    }
    public void clickByXpath(String xpath) throws InterruptedException {
        Thread.sleep(500);
        WebElement element = driver.findElement(By.xpath(xpath));
        String textOfElement=element.getText();
        element.click();
        test.log(Status.PASS,textOfElement+" is clicked");
        System.out.println(textOfElement+" is clicked");
    }
    public void enterByXpath(String xpath, String value){
        WebElement element =  driver.findElement(By.xpath(xpath));
        element.sendKeys(value);
        System.out.println(value+" entered ");
    }
    public void clickById(String id){
        WebElement element = driver.findElement(By.id(id));
        String textOfElement=element.getText();
        element.click();
        System.out.println(textOfElement+" is clicked");
    }
    public void enterById(String id, String value){
        WebElement element =  driver.findElement(By.id(id));
        element.sendKeys(value);
        System.out.println(value+" entered ");

    }
    public void clickByTagName(String tag){
        WebElement element = driver.findElement(By.tagName(tag));
        String textOfElement=element.getText();
        element.click();
        System.out.println(textOfElement+" is clicked");
    }
    public void enterByTagName(String tagName, String value){
        WebElement element =  driver.findElement(By.tagName(tagName));
        element.sendKeys(value);
        System.out.println(value+" entered ");
    }
    public void compareTextByXpath(String xpath, String expectedText){
        WebElement element =driver.findElement(By.xpath(xpath));
        String actual=element.getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains(expectedText),
                "Actual message does not contain expected message.\nActual Message: " + actual
                        + "\nExpected Message: " + expectedText);
        System.out.println(actual+" matches with "+expectedText);

    }
    public void selectCheckBoxesByXpath(String xpath, int num) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(xpath+"["+num+"]")).click();
        test.log(Status.PASS, "CheckBox: "+num+" is clicked");
        System.out.println("CheckBox: "+num+" is clicked");
    }
    public void dragBox1ToBox2(String box1Xpath, String box2Xpath) throws InterruptedException {
        Thread.sleep(1000);
        WebElement box1 = driver.findElement(By.xpath(box1Xpath));
        WebElement box2 = driver.findElement(By.xpath(box2Xpath));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(box1,box2).build().perform();
        Thread.sleep(1000);
        System.out.println("Successfully dragged and dropped");

    }
    public void selectDropDownByXpath(String xpath, String text) throws InterruptedException {
        Thread.sleep(1000);
        WebElement xpathElement = driver.findElement(By.xpath(xpath));
        Select dropDown = new Select(xpathElement);
        dropDown.selectByVisibleText(text);
        System.out.println(text+" selected from drop down");
    }

    public void alertAcceptByXpath() throws InterruptedException {
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("alert accepted");
    }

    public void windowSwitching() throws InterruptedException {
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("number of windows: "+ windowHandles.size());
        for (String w:windowHandles) {
            driver.switchTo().window(w);
            Thread.sleep(500);
            if (driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/windows/new")){
                System.out.println("Switched to new window");
                break;
            }
        }
        driver.switchTo().parentFrame();

    }

    }
