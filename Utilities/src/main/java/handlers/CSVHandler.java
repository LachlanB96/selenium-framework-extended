package handlers;

import java.io.*;
import java.util.ArrayList;

public class CSVHandler {

    private static String fileName;
    private static FileWriter fileWriter;
    private static FileReader fileReader;
    private static BufferedReader inStream;
    private static BufferedWriter outStream;

    public static void initialise() {
        FileHandler.setFileName(fileName);
        FileHandler.initialise();
    }
    //TODO:
    // Make an object that contains the csv file as whole
    public static ArrayList<String> readCSV() throws IOException {
        ArrayList<String> tempLines = FileHandler.readFile();
        System.out.printf("Size: %d", tempLines.size());
        String[][] dataTable = new String[tempLines.size()][];
        for(String tempLine : tempLines){
            String[] splitTempLine = tempLine.split(",");
        }
        return tempLines;
//        ArrayList<String> fileLines = new ArrayList<String>();
//        try {
//            inStream = new BufferedReader(fileReader);
//            String line;
//            line = inStream.readLine();
//            while(line != null) {
//                line = inStream.readLine();
//                fileLines.add(line);
//            }
//            inStream.close();
//            fileReader.close();
//        } catch (IOException e) {
//            System.out.println("111");
//            e.printStackTrace();
//            throw new IOException();
//        }
//        return fileLines;
    }


    public static void setFileName(String fileName) {
        CSVHandler.fileName = fileName;
    }


}
