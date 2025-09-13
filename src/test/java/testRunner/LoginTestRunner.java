package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/main/resources/features/",
        glue =    {"pom_with_stepsDef"},
        plugin = {"pretty","html:target/cucumber-report.html"},
        tags = "@LoginScenarios"


)

public class LoginTestRunner extends AbstractTestNGCucumberTests {
}
