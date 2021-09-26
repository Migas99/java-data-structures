package Exceptions;

public class VertexNotFoundException extends Exception {

    private final String message;

    public VertexNotFoundException() {
        this.message = "Vertex not found!";
    }

    public String getErrorMessage() {
        return this.message;
    }
}
