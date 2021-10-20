package sample;


public class App {

    public static void main(String[] args) throws CustomException {

        String testURL = "http://www.google.com";

        Driver.setCurrentDriver("chrome");
        Driver.goToURL(testURL);

        int a = 1;
        int b = 2;
        String c = "3";
        int d = 0;

        try {
            int x = a / d;
        } catch (Exception e){
            System.out.println("ERR0R: " + e);
            throw new CustomException(e);
        }
    }
}
