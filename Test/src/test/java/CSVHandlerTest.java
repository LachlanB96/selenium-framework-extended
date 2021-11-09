import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


//@CucumberOptions(features = "src/test/resources/features/Simple123Test.feature", glue = "MyStepDef")
public class CSVHandlerTest {

    private TestNGCucumberRunner testNGCucumberRunner;


    @Test(description = "Runs CSV Handler")
    public void feature() {
        //System.out.printf("Pickle: %s. Cucumber Feature: %s\n", pickle.getPickle().getName(), cucumberFeature.toString());
        System.out.printf("TeSTT\n\n");
//        for(Object[] scenario : scenarios){
//            for(Object simple : scenario){
//                System.out.printf(simple.toString());
//            }
//        }
    }


}