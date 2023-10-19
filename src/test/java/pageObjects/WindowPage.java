package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowPage {
    String firstWindowID;
    public WindowPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='openwindow']")
    WebElement OpenWindowPath;

    @FindBy(xpath = "//a[text() = 'Access all our Courses']")
    WebElement allCourses;
    @FindBy(xpath = "//h1[text() = 'Practice Page']")
    WebElement practicePage;
    @FindBy(xpath ="//span[text() = 'info@qaclickacademy.com']")
    WebElement email;

    @FindBy(xpath = "//input[@id='name']")
    WebElement input;

    public void clickOnWindow() {

        OpenWindowPath.click();
    }

    public void switchingToNewWindow() throws InterruptedException {

         firstWindowID = BaseClass.getDriver().getWindowHandle();
        System.out.println(firstWindowID);
        Set<String> multipleIDs = BaseClass.getDriver().getWindowHandles();
        System.out.println(multipleIDs.size());

        for (String m : multipleIDs) {
            if (!m.equals(firstWindowID)) {
                BaseClass.getDriver().switchTo().window(m);

            }

        }
        Thread.sleep(3000);

       String mytext = email.getText();
        System.out.println(mytext);

        BaseClass.getDriver().close();
    }

    public void switchingtoFirstWindow() throws InterruptedException {
        BaseClass.getDriver().switchTo().window(firstWindowID);
        input.sendKeys("Sumaia");
        BaseClass.getDriver().close();

    }
}
