package Exceptions;

public class EmptyCollectionException extends Exception {

    private final String message;

    public EmptyCollectionException() {
        this.message = "The collection is empty!";
    }

    public String getErrorMessage() {
        return this.message;
    }

}
