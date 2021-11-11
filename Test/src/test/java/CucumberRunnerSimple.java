import handlers.PrintHandler;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions(features = "src/test/resources/features/Simple123Test.feature", glue = "MyStepDef")
public class CucumberRunnerSimple {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }


    @Test(description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

//    @Test(description = "Runs Cucumber Feature")
//    public void feature() {
//        //System.out.printf("Pickle: %s. Cucumber Feature: %s\n", pickle.getPickle().getName(), cucumberFeature.toString());
//        System.out.printf("TeSTT\n\n");
//        Object[][] scenarios = testNGCucumberRunner.provideScenarios();
//        for(Object[] scenario : scenarios){
//            for(Object simple : scenario){
//                System.out.printf(simple.toString());
//            }
//        }
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