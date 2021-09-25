package Iterators;

public class BasicArrayIterator<T> implements BasicIteratorADT<T> {

    private final T[] elements;
    private int current;

    public BasicArrayIterator(T[] elements) {
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

