package LinkedList.List;

import java.util.Iterator;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;

public interface ListADT<T> extends Iterable<T> {

    T removeFirst() throws EmptyCollectionException;

    T removeLast() throws EmptyCollectionException;

    T remove(T element) throws EmptyCollectionException, ElementNotFoundException;

    T getFirst() throws EmptyCollectionException;

    T getLast() throws EmptyCollectionException;

    boolean contains(final T p0);

    boolean isEmpty();

    int size();

    Iterator<T> iterator();
}
