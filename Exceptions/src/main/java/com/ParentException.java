package com;

public class ParentException extends Throwable {

    ParentException(){
        System.out.println("Parent Exception Thrown");
    }

    ParentException(String message){
        System.out.println("%s Exception Thrown\n Parent Exception Thrown");
    }

    ParentException(String message, Exception e){
        System.out.println("%s Exception Thrown\n Parent Exception Thrown\n " + e);
    }

}
