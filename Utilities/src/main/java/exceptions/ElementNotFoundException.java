package exceptions;

public class ElementNotFoundException extends ParentException {
    ElementNotFoundException(){
        super("Parent Exception Thrown");
    }

    ElementNotFoundException(String message){
        super("%s Exception Thrown\n Parent Exception Thrown");
    }

    ElementNotFoundException(String message, Exception e){
        super("%s Exception Thrown\n Parent Exception Thrown\n " + e);
    }
}
