package LinkedLists.List;

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

        T element = this.elements[this.numElements];
        this.elements[this.numElements - 1] = null;
        this.numElements--;
        return element;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        T removedElement = null;
        boolean found = false;

        for(int index = 0; index < this.numElements && !found; index++) {
            if(element.equals(this.elements[index])) {
                removedElement = this.remove(index);
                found = true;
            }

            index++;
        }

        if (!found) {
            throw new ElementNotFoundException();
        }

        return removedElement;
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

        for (int index = 1; index <= this.size(); index++) {
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
        this.elements[elementIndex] = null;

        for (int index = elementIndex; index < this.numElements - 1; index++) {
            this.elements[index] = this.elements[index + 1];
        }

        this.elements[this.numElements - 1] = null;
        this.numElements--;
        return removedElement;
    }

}
