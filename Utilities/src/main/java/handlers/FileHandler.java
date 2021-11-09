package handlers;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static String fileName;
    private static FileWriter fileWriter;
    private static FileReader fileReader;
    private static BufferedReader inStream;
    private static BufferedWriter outStream;

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
                fileLines.add(line);
                line = inStream.readLine();
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

    public static void printFile() throws IOException {
        ArrayList<String> fileLines = new ArrayList<String>();
        try {
            inStream = new BufferedReader(fileReader);
            String line;
            line = inStream.readLine();
            System.out.println(line);
            while(line != null) {
                line = inStream.readLine();
                fileLines.add(line);
            }
            inStream.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("111");
            e.printStackTrace();
            throw new IOException();
        }
        for(String line : fileLines){
            System.out.println(line);
        }
    }

    public static void writeFile(String line){
        try {
            outStream = new BufferedWriter(fileWriter);
            outStream.write(line + "\n");
            outStream.close();
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
