package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "srt/test/resources/",
        glue = {"StepDefinitions"}

)
public class Run extends AbstractTestNGCucumberTests {
}
