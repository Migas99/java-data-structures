package Nodes;

public class DoubleNode<T> {

    private DoubleNode<T> next;
    private DoubleNode<T> previous;
    private T element;

    public DoubleNode() {
        this.next = null;
        this.previous = null;
        this.element = null;
    }

    public DoubleNode(final T element) {
        this.next = null;
        this.previous = null;
        this.element = element;
    }

    public DoubleNode<T> getNext() {
        return this.next;
    }

    public void setNext(DoubleNode<T> node) {
        this.next = node;
    }

    public DoubleNode<T> getPrevious() {
        return this.previous;
    }

    public void setPrevious(DoubleNode<T> node) {
        this.previous = node;
    }

    public T getElement() {
        return this.element;
    }

    public void setElement(T element) {
        this.element = element;
    }

}
