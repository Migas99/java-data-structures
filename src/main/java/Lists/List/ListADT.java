package Lists.List;

import java.util.Iterator;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;

public interface ListADT<T> extends Iterable<T> {

    T removeFirst() throws EmptyCollectionException;

    T removeLast() throws EmptyCollectionException;

    T removeFirst(T element) throws EmptyCollectionException, ElementNotFoundException;

    T removeLast(T element) throws EmptyCollectionException, ElementNotFoundException;

    void removeAll(T element) throws EmptyCollectionException, ElementNotFoundException;

    T getFirst() throws EmptyCollectionException;

    T getLast() throws EmptyCollectionException;

    boolean contains(T targetElement);

    boolean isEmpty();

    int size();

    Iterator<T> iterator();
}
