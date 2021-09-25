package Iterators;

import Nodes.Node;

import java.util.Iterator;

public class LinkedListIterator<T> implements Iterator<T> {

    private Node<T> current;

    public LinkedListIterator(Node<T> current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return this.current.getNext() != null;
    }

    @Override
    public T next() {
        Node<T> temp = this.current;
        this.current = this.current.getNext();
        return temp.getElement();
    }

}
