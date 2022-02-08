package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    @BeforeTest(alwaysRun = true)
    protected void setUp(){

        ChromeDriverFactory chFactory= new ChromeDriverFactory();
        driver=chFactory.createChromeBrowser();

    }
    @AfterClass(alwaysRun = true)
    protected void tearDown(){
        driver.quit();
        System.out.println("driver closed");
    }
}
