package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory {
    WebDriver driver;
    public WebDriver createChromeBrowser(){
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver");
        driver= new ChromeDriver();

        //Maximize window
        driver.manage().window().maximize();
        System.out.println("driver opened");
        return driver;
    }
}
