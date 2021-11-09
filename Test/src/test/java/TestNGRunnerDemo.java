import handlers.CSVHandler;
import handlers.FileHandler;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestNGRunnerDemo {

    @Test
    public void printString(){
        System.out.printf("TestNG Runner Demo\n");
    }

    @Test
    public void printInt(){
        System.out.printf("%d\n", 12345);
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

    @Test
    public void readCSV() throws IOException {


        CSVHandler.setFileName("sample.csv");
        CSVHandler.initialise();
        for(String line : CSVHandler.readCSV()){
            System.out.printf("%s\n", line);
        }
    }

}
