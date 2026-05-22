package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "@target/failed_scenarios.txt",
    glue = {"stepdefinitions", "hooks"},
    monochrome = true
)
public class FailedRunner extends AbstractTestNGCucumberTests {
}