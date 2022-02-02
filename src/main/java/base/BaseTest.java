package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    protected void setUp(){
        ChromeDriverFactory chFactory= new ChromeDriverFactory();
        driver=chFactory.createChromeBrowser();

    }
    @AfterMethod(alwaysRun = true)
    protected void tearDown(){
        //Close driver
        driver.quit();

        System.out.println("driver closed");
    }
}
