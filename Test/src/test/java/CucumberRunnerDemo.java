import handlers.PrintHandler;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions(features = "src/test/resources/features/", glue = "")
public class CucumberRunnerDemo {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(PickleWrapper pickle, FeatureWrapper cucumberFeature) {

        System.out.printf("Pickle: %s. Cucumber Feature: %s\n", pickle.getPickle().getName(), cucumberFeature.toString());
        if(pickle.getPickle().getName().equals("Test cucumber tests 111")){
            PrintHandler.colourPrintf(String.format("%s \n", pickle), "purple");
        }
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

//    @Test(groups = "cucumber123", description = "Runs Cucumber Feature", dataProvider = "features")
//    public void feature(CucumberFeatureWrapper cucumberFeature) {
//        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
//    }

//    @DataProvider
//    public Object[][] features() {
//        return testNGCucumberRunner.provideScenarios();
//    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}