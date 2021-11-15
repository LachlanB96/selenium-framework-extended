//import cucumber.runtime.model.CucumberFeature;
//import io.cucumber.testng.CucumberOptions;
//import io.cucumber.testng.FeatureWrapper;
//import io.cucumber.testng.PickleWrapper;
//import io.cucumber.testng.TestNGCucumberRunner;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//
//@CucumberOptions(features = "src/test/resources/features/Simple123Test.feature", glue = "StepDefinitions")
//public class Cucumber125 {
//
//    private TestNGCucumberRunner testNGCucumberRunner;
//
//    @BeforeClass(alwaysRun = true)
//    public void setUpClass() throws Exception {
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//    }
//
//
//    @Test(description = "Runs Cucumber Feature", dataProvider = "features")
//    public void feature(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
//        testNGCucumberRunner.runScenario(pickle.getPickle());
//    }
//
//
//    @DataProvider
//    public Object[][] features() {
////        for(CucumberFeature feature : testNGCucumberRunner.get)
////            testNGCucumberRunner.
//        return testNGCucumberRunner.provideScenarios();
//    }
//
//    @AfterClass(alwaysRun = true)
//    public void tearDownClass() throws Exception {
//        testNGCucumberRunner.finish();
//    }
//}