package Lists.List;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Iterators.DoubleLinkedListIterator;
import Nodes.DoubleNode;

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
    public T removeFirst(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        if (!this.contains(element)) {
            throw new ElementNotFoundException();
        }

        DoubleNode<T> current = this.first;
        DoubleNode<T> toRemoveNode = null;

        while (current.getNext() != null && toRemoveNode == null) {

            if (element.equals(current.getElement())) {
                toRemoveNode = this.remove(current);
            }

            current = current.getNext();
        }

        return toRemoveNode.getElement();
    }

    @Override
    public T removeLast(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        if (!this.contains(element)) {
            throw new ElementNotFoundException();
        }

        DoubleNode<T> current = this.last;
        DoubleNode<T> toRemoveNode = null;

        while (current.getPrevious() != null && toRemoveNode == null) {

            if (element.equals(current.getElement())) {
                toRemoveNode = this.remove(current);
            }

            current = current.getNext();
        }

        return toRemoveNode.getElement();
    }

    @Override
    public void removeAll(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        if (!this.contains(element)) {
            throw new ElementNotFoundException();
        }

        DoubleNode<T> current = this.first;

        while (current.getNext() != null) {

            if (element.equals(current.getElement())) {
                this.remove(current);
            }

            current = current.getNext();
        }
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
        while (current.getNext() != null) {
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

    // Assumes the list is not empty and the node exists
    private DoubleNode<T> remove(DoubleNode<T> toRemove) {

        if (this.size() == 1) {

            this.first = null;
            this.last = null;

            // If the size is two, we have to set the not removed element
            // to be both the first and last
        } else if (this.size() == 2) {

            if (this.first.equals(toRemove)) {
                this.first = this.last;
                this.first.setPrevious(null);
            } else {
                this.first.setNext(null);
                this.last = this.first;
            }

            // We're in the first element
        } else if (this.first.equals(toRemove)) {
            this.first = toRemove.getNext();
            this.first.setPrevious(null);

            // We're in the last element
        } else if (this.last.equals(toRemove)) {
            this.last = toRemove.getPrevious();
            this.last.setNext(null);

            // Else, we're just on the middle
        } else {
            DoubleNode<T> previous = toRemove.getPrevious();
            DoubleNode<T> next = toRemove.getNext();

            previous.setNext(next);
            next.setPrevious(previous);
        }

        this.numElements--;
        return toRemove;
    }

}
