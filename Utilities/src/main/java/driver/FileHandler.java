package driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

    private static String fileName;
    private static FileWriter fileWriter;
    private static FileReader fileReader;
    private static BufferedReader inStream;

    public static void initialise() {
        try {
            fileWriter = new FileWriter(getFileName(), true);
            fileReader = new FileReader(fileName);
        } catch (IOException e){
            System.out.println("IO EXCEPTION");
            //throw new IOException();
        }
        inStream = new BufferedReader(fileReader);
    }

    public static ArrayList<String> readFile() throws IOException {
        ArrayList<String> fileLines = new ArrayList<String>();
        try {
            inStream = new BufferedReader(fileReader);
            String line;
            line = inStream.readLine();
            while(line != null) {
                System.out.print(line);
                line = inStream.readLine();
                System.out.print(line);
            }
            inStream.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("111");
            e.printStackTrace();
            throw new IOException();
        }
        return fileLines;
    }

    public static void writeFile(String line){
        try {
            fileWriter.write(line + "\n");
        } catch (Exception e) {
            System.out.println("Error writing to file");
            e.printStackTrace();
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
