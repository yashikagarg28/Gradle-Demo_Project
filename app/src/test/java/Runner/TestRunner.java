package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D:\\GradleDemo\\app\\src\\test\\resources\\Feature",
        glue = {"StepDefinitions"},monochrome = true
)
public class TestRunner {

}
