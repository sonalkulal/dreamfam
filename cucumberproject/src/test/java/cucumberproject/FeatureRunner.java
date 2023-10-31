package cucumberproject;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/Features",glue="com.cucumberproject.steps")
public class FeatureRunner extends AbstractTestNGCucumberTests {

}

