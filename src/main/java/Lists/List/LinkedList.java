package Lists.List;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Iterators.LinkedListIterator;
import Lists.Nodes.Node;

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

            while (current.getNext() != this.last) {
                current = current.getNext();
            }

            this.last = current;
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

        Node<T> previous = null;
        Node<T> current = this.first;
        Node<T> toRemoveNode = null;

        while (current.getNext() != null && toRemoveNode == null) {
            if (element.equals(current.getElement())) {
                toRemoveNode = this.remove(previous, current);
            }

            previous = current;
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

        Node<T> previous = null;
        Node<T> current = this.first;
        Node<T> previousOfToRemoveNode = null;
        Node<T> toRemoveNode = null;

        while (current.getNext() != null) {
            if (element.equals(current.getElement())) {
                previousOfToRemoveNode = previous;
                toRemoveNode = current;
            }

            previous = current;
            current = current.getNext();
        }

        this.remove(previousOfToRemoveNode, toRemoveNode);
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

        Node<T> previous = null;
        Node<T> current = this.first;

        while (current.getNext() != null) {
            if (element.equals(current.getElement())) {
                this.remove(previous, current);
                current = previous;
            }

            previous = current;
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
        Node<T> current = this.first;
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
        return new LinkedListIterator<T>(this.first);
    }

    // Assumes the list is not empty and the node exists
    private Node<T> remove(Node<T> previous, Node<T> toRemove) {

        if (this.size() == 1) {

            this.first = null;
            this.last = null;

            // If the size is two, we have to set the not removed element
            // to be both the first and last
        } else if (this.size() == 2) {

            if (this.first.equals(toRemove)) {
                this.first = this.last;
            } else {
                this.first.setNext(null);
                this.last = this.first;
            }

            // We're in the first element
        } else if (this.first.equals(toRemove)) {
            this.first = toRemove.getNext();

            // we're in the last element
        } else if (this.last.equals(toRemove)) {
            this.last = previous;
            this.last.setNext(null);

            // Else, we're just on the middle
        } else {
            previous.setNext(toRemove.getNext());
        }

        this.numElements--;
        return toRemove;
    }
}
