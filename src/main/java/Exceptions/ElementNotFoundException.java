package Exceptions;

public class ElementNotFoundException extends Exception {

    private final String message;

    public ElementNotFoundException() {
        this.message = "The element was not found!";
    }

    public String getErrorMessage() {
        return this.message;
    }

}
