package testRunner;


import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/main/resources/features",
        glue =    {"pom_with_steps",""},
        plugin = {          "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cukes.xml",
                "rerun:target/rerun.txt"},

        tags = "@smoke"

)

public class TestRunner {
}
