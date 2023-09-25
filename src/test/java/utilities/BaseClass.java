package utilities;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    private static WebDriver driver;

    public BaseClass () throws InterruptedException, IOException {
        FileInputStream fis = new FileInputStream("/Users/sumaiar122/IdeaProjects/Selenium_Batch-6-cucumber/src/test/java/env.properties");
        Properties prop = new Properties();
        prop.load(fis);

       String myURL = prop.getProperty("RahulShettyppURL");
        System.out.println(myURL);

        String myBrowser = prop.getProperty("browser");
        System.out.println(myBrowser);




            if (myBrowser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();  //open the browser
            }

          else if (myBrowser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();  //open the browser
            }
        else{
            System.out.println("check the driver");
        }

            driver.get(myURL); // Navigate to the base URL
            driver.manage().window().maximize();
            Thread.sleep(3000);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

    }





    public static WebDriver getDriver() throws InterruptedException {
        return driver;
    }

    public static void setDriver() throws InterruptedException, IOException {
        BaseClass obj = new BaseClass();

    }
}
