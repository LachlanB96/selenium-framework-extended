package driver;

public class AssertDriver {

    public static boolean assertTrue(boolean assertion){
        LogHandler.standardLog(String.format("%b", assertion), "TEST");
        return assertion;
    }

    public static boolean assertTrue(boolean assertion, String assertMessage){
        LogHandler.standardLog(String.format("%s is: %b", assertMessage, assertion), "TEST");
        return assertion;

        //TODO look at soft assertion vs hard assertion
        // add excel file importer
        // make testng test identical to feature file
        // Maven command to run testng test and mavben cmmand to run feature file
        // Bonus: run cucumber feature file from testng test (pass dataprovider through testng to cucumber)
    }

}
