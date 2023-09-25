package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverOver {
    //with the help of action class we can do right click, double click, drag and drop
// with the help of action class we can do the keyboard handling...like Ctrl C, Ctrl V, press on Shift

    WebDriver driver;

//    @Given("browser is open and navigate to the Base URL")
//    public void browser_is_open_and_navigate_to_the_Base_URL () throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();  //open the browser
//      //  driver.get("https://uprightforum.tech/practice"); // Navigate to the base URL
//       driver.get("https://www.amazon.com/");
//        driver.manage().window().maximize();
//        Thread.sleep(3000);
//    }


    @When("user hover the mouse over the option")

    public void user_hover_the_mouse_over_the_option() {
       // WebElement hoverPath = driver.findElement(By.xpath("//span[contains(@id, 'select2-mouse-hover')]"));
        WebElement hoverPathforAmazon = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        new Actions(driver).moveToElement(hoverPathforAmazon).build().perform();

    }

    @Then("user can select Option one using Actions Class")
    public void user_can_select_option_one_using_action_class() throws InterruptedException {
WebElement ordersPath = driver.findElement(By.xpath("//span[text() = 'Orders']"));
    ordersPath.click();
        //executing double and right click
        WebElement emailPath = driver.findElement(By.xpath("//input[@id = 'ap_email"));
       //Right click on email field
        new Actions(driver).contextClick(emailPath).build().perform();
       Thread.sleep(3000);
        new Actions(driver).sendKeys("Sumaia").build().perform();
        WebElement continuePath = driver.findElement(By.xpath("//input[@id='continue']"));
        //double click on continue
        new Actions(driver).doubleClick(continuePath).build().perform();

    }

    @Then("user can select Option two using Actions Class")
    public void user_can_select_option_two_using_action_class() {

    }



}
