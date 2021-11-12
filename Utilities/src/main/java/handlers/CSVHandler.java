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

    public static String[][] readCSV() throws IOException {
        ArrayList<String> sheet = FileHandler.readFile();
        String[][] dataTable = new String[sheet.size()][];
        int lineNumber = 0;
        int colNum = 0;
        for(String row : sheet){
            String[] splitTempLine = row.split(",");
            dataTable[lineNumber] = new String[splitTempLine.length];
            for(String cell : splitTempLine){
                dataTable[lineNumber][colNum] = cell;
                colNum++;
            }
            lineNumber++;
            colNum = 0;
        }
        return dataTable;
    }


    public static void setFileName(String fileName) {
        CSVHandler.fileName = fileName;
    }


}
