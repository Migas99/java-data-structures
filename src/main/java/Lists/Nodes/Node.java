package Lists.Nodes;

public class Node<T> {

    private Node<T> next;
    private T element;

    public Node() {
        this.next = null;
        this.element = null;
    }

    public Node(T element) {
        this.next = null;
        this.element = element;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> node) {
        this.next = node;
    }

    public T getElement() {
        return this.element;
    }

    public void setElement(T element) {
        this.element = element;
    }

}
