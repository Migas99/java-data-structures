package Iterators;

import Lists.Nodes.DoubleNode;

import java.util.Iterator;

public class DoubleLinkedListIterator<T> implements Iterator<T> {

    private DoubleNode<T> current;

    public DoubleLinkedListIterator(DoubleNode<T> current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return this.current.getNext() != null;
    }

    @Override
    public T next() {
        DoubleNode<T> temp = this.current;
        this.current = this.current.getNext();
        return temp.getElement();
    }

}
