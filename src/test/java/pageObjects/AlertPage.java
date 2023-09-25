package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseClass;

public class AlertPage {
    // Constructor
    // Page Elements
    // Methods according to actions
    public AlertPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class = 'onclick']")
    WebElement tryItPath;

    public void clickOnTryit() {
        tryItPath.click();
    }

    public void validateAlertBox() throws InterruptedException {
        String alertText = BaseClass.getDriver().switchTo().alert().getText();
        if (alertText.contains("alert"))
            System.out.println("Alert box is present");
        else
            System.out.println("Alert box is not there");

    }

     public void acceptAlert() throws InterruptedException {
         Thread.sleep(3000);
         BaseClass.getDriver().switchTo().alert().accept();
     }

}

