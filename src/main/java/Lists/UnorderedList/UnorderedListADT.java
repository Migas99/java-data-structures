package Lists.UnorderedList;

import Exceptions.ElementNotFoundException;
import Lists.List.ListADT;

public interface UnorderedListADT<T> extends ListADT<T> {

    void addToFront(T element);

    void addToRear(T element);

    void addAfter(T targetElement, T elementToAdd) throws ElementNotFoundException;

}
