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
        ArrayList<String> sheet = FileHandler.readFile();
        System.out.printf("Size: %d\n\n", sheet.size());
        String[][] dataTable = new String[sheet.size()][];
        int lineNumber = 0;
        int colNum = 0;
        for(String row : sheet){
            String[] splitTempLine = row.split(",");
            System.out.printf("Size: %d\n", splitTempLine.length);
            dataTable[lineNumber] = new String[splitTempLine.length];
            for(String cell : splitTempLine){
                dataTable[lineNumber][colNum] = cell;
                colNum++;
            }
            lineNumber++;
            colNum = 0;
        }

        for(String[] row : dataTable){
            for(String col : row){
                System.out.printf("%s|", col);
            }
            System.out.printf("\n----------------------------\n");
        }
        return sheet;
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
