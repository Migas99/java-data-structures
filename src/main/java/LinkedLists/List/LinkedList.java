package LinkedLists.List;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Iterators.LinkedListIterator;
import Nodes.Node;

import java.util.Iterator;

public class LinkedList<T> implements ListADT<T> {

    protected int numElements;
    protected Node<T> first;
    protected Node<T> last;

    public LinkedList() {
        this.numElements = 0;
        this.first = null;
        this.last = null;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        T removedElement = this.first.getElement();

        if (this.numElements == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.getNext();
        }

        this.numElements--;
        return removedElement;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        T removedElement = this.last.getElement();

        if (this.numElements == 1) {
            this.first = null;
            this.last = null;
        } else {
            Node<T> current = this.first;

            while(current.getNext() != this.last) {
                current = current.getNext();
            }

            this.last = current;
            this.last.setNext(null);
        }

        this.numElements--;
        return removedElement;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        if(!this.contains(element)) {
            throw new ElementNotFoundException();
        }

        T removedElement = null;

        if (element.equals(this.first.getElement())) {
            removedElement = this.first.getElement();

            if(this.size() == 1) {
                this.first = null;
                this.last = null;
            } else {
                this.first = this.first.getNext();
            }

        } else {
            Node<T> previous = null;
            Node<T> current = this.first;

            while(current.getNext() != null) {
                if(element.equals(current.getElement())) {
                    removedElement = current.getElement();
                    previous.setNext(current.getNext());
                }

                previous = current;
                current = current.getNext();
            }
        }

        this.numElements--;
        return removedElement;
    }

    @Override
    public T getFirst() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        return this.first.getElement();
    }

    @Override
    public T getLast() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        return this.last.getElement();
    }

    @Override
    public boolean contains(T targetElement) {
        Node<T> current = this.first;
        while(current.getNext() != null) {
            if (current.getElement().equals(targetElement)) {
                return true;
            }

            current = current.getNext();
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
        return new LinkedListIterator<T>(this.first);
    }

}
