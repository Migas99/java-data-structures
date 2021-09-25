package LinkedLists.UnorderedList;

import Exceptions.ElementNotFoundException;
import LinkedLists.List.ArrayList;

public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    @Override
    public void addToFront(T element) {
        if (this.elements.length == this.numElements) {
            this.expandCapacity();
        }

        for (int index = this.numElements; index > 0; index++) {
            this.elements[index] = this.elements[index - 1];
        }

        this.elements[0] = element;
        this.numElements++;
    }

    @Override
    public void addToRear(T element) {
        if (this.elements.length == this.numElements) {
            this.expandCapacity();
        }

        this.elements[this.numElements] = element;
        this.numElements++;
    }

    @Override
    public void addAfter(T targetElement, T elementToAdd) throws ElementNotFoundException {
        if (this.elements.length == this.numElements) {
            this.expandCapacity();
        }

        if(!this.contains(targetElement)) {
            throw new ElementNotFoundException();
        }

        int targetIndex = 0;
        for(int index = 0; index < this.numElements; index++) {
            if(targetElement.equals(this.elements[index])) {
                targetIndex = index;
            }
        }

        for(int index = this.numElements; targetIndex < index; index--) {
            this.elements[index] = this.elements[index - 1];
        }

        this.elements[targetIndex + 1] = elementToAdd;
        this.numElements++;
    }

}
