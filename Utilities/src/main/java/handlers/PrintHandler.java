package handlers;


import java.util.HashMap;
import java.util.Map;


public class PrintHandler {

    public static final String RESET = "\033[0m";  // Text Reset

    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    public static Map<String, String> colours = new HashMap<>();

    public static void init(){
        colours.put("reset", RESET);
        colours.put("black", BLACK);
        colours.put("red", RED);
        colours.put("blue", BLUE);
        colours.put("purple", PURPLE);
    }

    public static void colourPrintf(String message, String colour){
        if(colours.size() == 0){
            PrintHandler.init();
        }
        System.out.print(colours.get(colour) + message);
        System.out.print(RESET);
    }
}
