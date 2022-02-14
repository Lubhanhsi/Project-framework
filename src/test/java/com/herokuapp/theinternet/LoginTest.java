package com.herokuapp.theinternet;
import org.testng.annotations.*;
import pages.BaseMethods;
import base.BaseTest;

public class LoginTest extends BaseTest{
    BaseMethods base;
    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 1, enabled = true)
    public void loginTest(String uname, String pswd, String message) throws InterruptedException{
        String url="https://the-internet.herokuapp.com/";
        String formAuthXpath="//a[text()='Form Authentication']";
        String loginSuccessTextXpath="//div[@id='flash']";
//        base = new BaseMethods(driver);
        base.openURL(url);
        base.clickByXpath(formAuthXpath);
        base.enterById("username",uname);
        Thread.sleep(3000);
        base.enterById("password",pswd);
        base.clickByTagName("button");
        base.compareTextByXpath(loginSuccessTextXpath, message);
    }

}
