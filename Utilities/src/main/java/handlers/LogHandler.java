package handlers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.String.format;

public class LogHandler {

    public static void standardLog(String message, String level){
        FileHandler.setFileName("standard-log.txt");
        FileHandler.initialise();

        SimpleDateFormat formatter = new SimpleDateFormat("kk:mm:ss");
        String timeIn24Hours = formatter.format(new Date());
        String logMessage = format("[%s][%s] %s", timeIn24Hours, level, message);

        FileHandler.writeFile(logMessage);
    }

    public static void printLog(int linesToPrint) throws IOException {
        FileHandler.setFileName("standard-log.txt");
        FileHandler.initialise();
        ArrayList<String> fileLines = FileHandler.readFile();
        int i = 1;
        for(String line : fileLines){
            System.out.println(line);
            i++;
            if(i > linesToPrint) break;
        }
    }
}
