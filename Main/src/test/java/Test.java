import java.io.*;

public class Test {

    //add unit testing strtucture
    public static void main(String[] args) {
        String url = "http://www.google.com";
        String[] strArray = url.split("");
        System.out.println(strArray[0]);
        System.out.println(strArray[1]);
        System.out.println(strArray[2]);

        String fileName = "./sample.txt";

// Write the content in file
        try(FileWriter fileWriter = new FileWriter(fileName, true)) {
            String fileContent = "This is a sample text.";
            fileWriter.write(fileContent);
            fileWriter.close();
        } catch (IOException e) {
            // Cxception handling
        }

// Read the content from file
        try(FileReader fileReader = new FileReader(fileName)) {
            BufferedReader inStream = new BufferedReader(fileReader);
            String inString;
            while ((inString = inStream.readLine()) != null) {
                System.out.print(inString);
                fileReader.close();
            }
            inStream.close();
        } catch (FileNotFoundException e) {
            // Exception handling
        } catch (IOException e) {
            // Exception handling
        }
    }
}
