package driver;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    private static String fileName;
    private static FileWriter fileWriter;

    public static void initialise() {
        try {
            fileWriter = new FileWriter(getFileName(), true);
        } catch (IOException e){
            System.out.println("IO EXCEPTION");
        }
    }

    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        FileHandler.fileName = fileName;
    }



    //public static String readFile(){}

}
