package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features/WindowHandling.feature"}, glue = {"stepDefination"},

        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },

// plugin = { "pretty", "html.target/cucumber-reports/Cucumber.html"},
        monochrome = true,
        publish = true
)

/* Cucumber options is an annotations ... it takes two parameters
one is feature location another is step def location
if you have 100 feature file in a package ... give path only upto package level like
src/test/java/features/
or if you want to run a specific feature file give src/test/java/features/Login.feature
 */



public class RunnerClass {


}
