package Lists.UnorderedList;

import Exceptions.ElementNotFoundException;
import Lists.List.DoubleLinkedList;
import Nodes.DoubleNode;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

    @Override
    public void addToFront(T element) {
        DoubleNode<T> newNode = new DoubleNode<T>(element);

        if (this.isEmpty()) {
            this.first = newNode;
            this.last = newNode;
            this.first.setNext(this.last);
            this.last.setPrevious(this.first);
        } else {
            newNode.setNext(this.first);
            this.first.setPrevious(newNode);
            this.first = newNode;
        }

        this.numElements++;
    }

    @Override
    public void addToRear(T element) {

    }

    @Override
    public void addAfter(T targetElement, T elementToAdd) throws ElementNotFoundException {

    }

}
