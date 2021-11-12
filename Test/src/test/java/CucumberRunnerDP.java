import handlers.PrintHandler;
import io.cucumber.testng.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions(features = "src/test/resources/features/", glue = "StepDefinitions", dryRun = true)
public class CucumberRunnerDP {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(PickleWrapper pickle, FeatureWrapper cucumberFeature, String[] data) {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @Test(description = "Runs Cucumber 2")
    public void feature2() {
        Object[][] scenarios = testNGCucumberRunner.provideScenarios();
        System.out.println(scenarios[0][0]);
        System.out.println(scenarios[0][2]);
        System.out.println(scenarios[1][0]);
        System.out.println(scenarios[1][1]);
        System.out.println((Pickle) scenarios[0][0]);

        testNGCucumberRunner.runScenario((Pickle) scenarios[0][0]);
        System.out.println(scenarios[0][0].getClass());
        for(Object[] feature : scenarios){
            System.out.println(feature.getClass());
        }

    }


    @DataProvider
    public Object[][] features() {
        String[][] data = {{"1", "2", "3"}, {"11", "22", "33"}, {"111", "222", "333"}};
        Object[][] rawScenarios = testNGCucumberRunner.provideScenarios();
        Object[][] scenarios = new Object[rawScenarios.length][3];
        for (int i = 0; i < rawScenarios.length; i ++) {
            scenarios[i][0] = rawScenarios[i][0];
            scenarios[i][1] = rawScenarios[i][1];
            scenarios[i][2] = data[1];
        }
        return scenarios;
    }

//    @DataProvider
//    public Object[][] features() {
//        Object[][] test;
//        test = new Object[][]{{"2", "2"}, {"3", "4"}};
//        //testNGCucumberRunner.provideScenarios();
//        return test;
//    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}