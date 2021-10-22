public class Test {
    public static void main(String[] args) {
        String url = "http://www.google.com";
        String[] strArray = url.split(":");
        System.out.println(strArray[0]);
    }
}
