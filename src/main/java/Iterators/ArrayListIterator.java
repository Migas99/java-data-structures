package Iterators;

import java.util.Iterator;

public class ArrayListIterator<T> implements Iterator<T> {

    private final T[] elements;
    private int current;

    public ArrayListIterator(T[] elements) {
        this.elements = elements;
        this.current = 0;
    }

    @Override
    public boolean hasNext() {
        return this.elements[this.current] != null;
    }

    @Override
    public T next() {
        this.current++;
        return this.elements[this.current - 1];
    }

}

