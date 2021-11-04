import org.testng.annotations.Test;

public class TestNGRunnerDemo {

    @Test
    public void printString(){
        System.out.printf("TestNG Runner Demo");
    }

    @Test
    public void printInt(){
        System.out.print(99999);
    }

}
