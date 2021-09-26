package Lists.List;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Iterators.ArrayIterator;

import java.util.Iterator;

public class ArrayList<T> implements ListADT<T> {

    protected final int DEFAULT_CAPACITY;
    protected int numElements;
    protected T[] elements;

    public ArrayList() {
        this.DEFAULT_CAPACITY = 10;
        this.numElements = 0;
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        return this.remove(0);
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        return this.remove(this.numElements - 1);
    }

    @Override
    public T removeFirst(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        if(!this.contains(element)) {
            throw new ElementNotFoundException();
        }

        T toRemove = null;
        for(int index = 0; index < this.numElements && toRemove == null; index++) {
            if(element.equals(this.elements[index])) {
                toRemove = this.remove(index);
            }
        }

        return toRemove;
    }

    @Override
    public T removeLast(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        if(!this.contains(element)) {
            throw new ElementNotFoundException();
        }

        T toRemove = null;
        for(int index = this.numElements - 1; index >= 0 && toRemove == null; index--) {
            if(element.equals(this.elements[index])) {
                toRemove = this.remove(index);
            }
        }

        return toRemove;
    }

    @Override
    public void removeAll(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        if(!this.contains(element)) {
            throw new ElementNotFoundException();
        }

        for(int index = 0; index < this.numElements; index++) {
            if(element.equals(this.elements[index])) {
                this.remove(index);
            }
        }

    }

    @Override
    public T getFirst() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        return this.elements[0];
    }

    @Override
    public T getLast() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        return this.elements[this.numElements - 1];
    }

    @Override
    public boolean contains(T targetElement) {
        if (this.isEmpty()) {
            return false;
        }

        for (int index = 0; index < this.numElements; index++) {
            if (targetElement.equals(this.elements[index])) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.numElements == 0;
    }

    @Override
    public int size() {
        return this.numElements;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<T>(this.elements);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int index = 0; index < this.numElements; index++) {
            builder.append("[Position: ").append(index).append(" -> Value: ").append(this.elements[index]).append("]\n");
        }

        return builder.toString();
    }

    protected void expandCapacity() {
        T[] expandedList = (T[]) new Object[this.numElements + this.DEFAULT_CAPACITY];

        for (int index = 0; index < this.numElements; index++) {
            expandedList[index] = this.elements[index];
        }

        this.elements = expandedList;
    }

    private T remove(int elementIndex) {
        T removedElement = this.elements[elementIndex];

        for (int index = elementIndex; index < this.numElements - 1; index++) {
            this.elements[index] = this.elements[index + 1];
        }
        this.elements[this.numElements - 1] = null;

        this.numElements--;
        return removedElement;
    }

}
