import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/SimpleTest.feature", glue = "")

public class CucumberRunner extends  AbstractTestNGCucumberTests {
}
