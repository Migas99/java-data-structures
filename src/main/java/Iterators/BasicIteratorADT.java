package Iterators;

import java.util.Iterator;

public interface BasicIteratorADT<T> extends Iterator<T> {

    @Override
    boolean hasNext();

    @Override
    public T next();

}
