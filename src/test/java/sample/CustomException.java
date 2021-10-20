package sample;

import org.openqa.selenium.NoSuchElementException;

import java.lang.*;

public class CustomException extends Exception {

    public CustomException(Exception e, String message){

        super();

        System.out.println(e);
        System.out.println(message);

//        if(e == NoSuchElementException){
//            //Do Stuff
//        }

//        switch(e) {
//            case java.lang.ArithmeticException:
//                System.out.println("Divide by 0 error");
//                break;
//            case y:
//                // code block
//                break;
//            default:
//                // code block
//        }

    }

}
