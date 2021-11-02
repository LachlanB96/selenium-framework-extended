package driver;

public class AssertDriver {

    public static boolean assertTrue(boolean assertion){
        LogHandler.standardLog(String.format("%b", assertion), "TEST");
        return assertion;
    }

    public static boolean assertTrue(boolean assertion, String assertMessage){
        LogHandler.standardLog(String.format("%s is: %b", assertMessage, assertion), "TEST");
        return assertion;
    }

}
