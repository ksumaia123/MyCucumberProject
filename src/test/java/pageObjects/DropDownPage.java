package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownPage {
    // Constructor
    // Page elements
    // methods according to actions

    Select obj;
    public DropDownPage(WebDriver driver) {
        PageFactory.initElements(driver,this );
    }

    @FindBy(linkText = "https://uprightforum.tech/practice/")
    WebElement practiceLinkPath;

    @FindBy(xpath = "//select[@class='form-control']")
    WebElement selectPath;


    public void clickOnPractice(){
        practiceLinkPath.click();
    }

    public void clickOnSelectanOption(){
         obj = new Select(selectPath);
           List<WebElement> myOptions = obj.getOptions();
           int size = myOptions.size();

           for(int i=0; i<size; i++){
               String mytext = myOptions.get(i).getText();
               System.out.println(mytext);
           }
        obj.selectByVisibleText("Select an Option");
    }

    public void clickOnOptionOne(){
        obj.selectByIndex(0);
    }

    public void clickOnOptionTwo(){
        obj.selectByIndex(1);
    }

    public void clickOnOptionThree(){
    obj.selectByIndex(2);
    }



}
