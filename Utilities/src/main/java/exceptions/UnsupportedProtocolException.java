package exceptions;

public class UnsupportedProtocolException extends ParentException {

    public UnsupportedProtocolException(String protocol) {
        System.out.printf("The system does not currently support %s protocol.%n", protocol);
    }
}
