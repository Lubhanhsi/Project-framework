package assignment;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BaseMethods;


public class Assignment extends BaseTest {

    BaseMethods base;
    String url="https://the-internet.herokuapp.com/";
    @Test()
    public void checkBoxFunctionality() throws InterruptedException {
        base= new BaseMethods(driver , test);
        String checkBoxLinkXpath="//a[text()='Checkboxes']";
        String checkBoxOnPage= "//input[@type='checkbox']";
        base.openURL(url);
        base.clickByXpath(checkBoxLinkXpath);
        base.selectCheckBoxesByXpath(checkBoxOnPage, 1);
        base.selectCheckBoxesByXpath(checkBoxOnPage, 2);
        base.navigateBackFromCurrentPage();
    }

   /* @Test
    public void dragAndDropFunctionality() throws InterruptedException {
        base= new BaseMethods(driver);
        String dragAndDropXpath= "//a[text()='Drag and Drop']";
        String boxesXpath="//h3[text()='Drag and Drop']/parent::div/div/child::div";
        base.openURL(url);
        base.clickByXpath(dragAndDropXpath);
        base.dragBox1ToBox2(boxesXpath+"[1]",boxesXpath+"[2]");
    }

    @Test
    public void dropDownFunctionality() throws InterruptedException {
        base = new BaseMethods(driver);
        String dropDownXpath="//a[text()='Dropdown']";
        String dropDownValuesXpath = "//select[@id='dropdown']";
        base.openURL(url);
        base.clickByXpath(dropDownXpath);
        base.selectDropDownByXpath(dropDownValuesXpath, "Option 2");

    }

    @Test
    public void forgotPasswordFunctionality() throws InterruptedException {
        base = new BaseMethods(driver);
        String forgotPasswordXpath="//a[text()='Forgot Password']";
        String emailTextBoxXpath="//input[@id='email']";
        String retrieveButtonXpath="//button[@id='form_submit']";
        String errorXpath="//h1[text()='Internal Server Error']";
        String errorText="Internal Server Error";
        base.openURL(url);
        base.clickByXpath(forgotPasswordXpath);
        base.enterByXpath(emailTextBoxXpath,"jessy123@herokuapp.com");
        base.clickByXpath(retrieveButtonXpath);
        base.compareTextByXpath(errorXpath,errorText);

    }

    @Test
    public void basicWindowsHandlingFunctionality() throws InterruptedException {
        base = new BaseMethods(driver);
        String multipleWinLink="//a[text()='Multiple Windows']";
        String newWinXpathLink = "//a[text()='Click Here']";
        base.openURL(url);
        base.clickByXpath(multipleWinLink);
        base.clickByXpath(newWinXpathLink);
        base.windowSwitching();

    }
*/
    }
