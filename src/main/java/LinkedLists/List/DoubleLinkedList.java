package LinkedLists.List;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Iterators.DoubleLinkedListIterator;
import Nodes.DoubleNode;
import Nodes.Node;

import java.util.Iterator;

public class DoubleLinkedList<T> implements ListADT<T> {

    protected int numElements;
    protected DoubleNode<T> first;
    protected DoubleNode<T> last;

    public DoubleLinkedList() {
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

        if (this.size() == 1) {
            this.last = null;
            this.first = null;
        } else {
            this.first = this.first.getNext();
            this.first.setPrevious(null);
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

        if (this.size() == 1) {
            this.last = null;
            this.first = null;
        } else {
            this.last = this.last.getPrevious();
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

        if(element.equals(this.first.getElement())) {
            removedElement = this.first.getElement();

            if(this.size() == 1) {
                this.first = null;
                this.last = null;
            } else {
                this.first = this.first.getNext();
                this.first.setPrevious(null);
            }

        } else if(element.equals(this.last.getElement())) {
            removedElement = this.last.getElement();
            this.last = this.last.getPrevious();
            this.last.setNext(null);

        } else {
            DoubleNode<T> current = this.first;

            while(current.getNext() != this.last) {
                if(element.equals(current.getElement())) {
                    removedElement = current.getElement();
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                }

                current = current.getNext();
            }
        }

        this.numElements++;
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
        DoubleNode<T> current = this.first;
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
        return new DoubleLinkedListIterator<T>(this.first);
    }

}
