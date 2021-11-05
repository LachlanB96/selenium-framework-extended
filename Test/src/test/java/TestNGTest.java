import handlers.FileHandler;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestNGTest {

    @Test
    public void printString(){
        System.out.printf("TestNG Runner Demo");
    }

    @Test
    public void printInt(){
        System.out.print(99999);
    }

    @Test
    public void writeFile(){
        FileHandler.setFileName("testRead.txt");
        FileHandler.initialise();
        FileHandler.writeFile("Test Line!");
    }

    @Test
    public void readFile() throws IOException {
        FileHandler.setFileName("testRead.txt");
        FileHandler.initialise();
        FileHandler.printFile();
    }

}