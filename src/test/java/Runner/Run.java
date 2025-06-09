package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources",
        glue = {"StepDefinitions"},
        tags = "@ListTests"
)
public class Run extends AbstractTestNGCucumberTests {
}
