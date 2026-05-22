package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefinitions", "hooks"},
    plugin = {
    "pretty",
    "html:target/cucumber-report.html",
    "json:target/cucumber.json",
    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
    "rerun:target/failed_scenarios.txt"
},
    monochrome = true
)

public class TestRunnerTest extends AbstractTestNGCucumberTests {
}