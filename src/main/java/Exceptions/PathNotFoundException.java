package Exceptions;

public class PathNotFoundException extends Exception {

    private final String message;

    public PathNotFoundException() {
        this.message = "Path doesn't exist!";
    }

    public String getErrorMessage() {
        return this.message;
    }
}
