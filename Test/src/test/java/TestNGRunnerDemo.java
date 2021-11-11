import handlers.CSVHandler;
import handlers.FileHandler;
import handlers.PrintHandler;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestNGRunnerDemo {

    @Parameters({ "string" })
    @Test
    public void printString(String val){
        System.out.printf("TestNG Runner Demo %s\n", val);
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
        PrintHandler.colourPrintf("\n----------\n", "red");
        for(String[] row : CSVHandler.readCSV()){
            PrintHandler.colourPrintf("|", "red");
            for(String col : row){
                PrintHandler.colourPrintf(String.format("%s", col), "blue");
                PrintHandler.colourPrintf("|", "red");
            }
            PrintHandler.colourPrintf("\n----------\n", "red");
        }
    }

}
