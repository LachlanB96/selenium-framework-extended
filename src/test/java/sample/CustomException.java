package sample;

import java.lang.*;

public class CustomException extends Exception {

    public CustomException(Exception e){

        super("test");

        System.out.println(e);

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
