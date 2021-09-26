package Lists.UnorderedList;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class TestUnorderedArrayList {

    private UnorderedArrayList<Integer> getUnorderedArrayList() {
        UnorderedArrayList<Integer> unorderedArrayList = new UnorderedArrayList<>();

        for(int i=0; i<100; i++) {
            unorderedArrayList.addToRear(i);
        }

        return unorderedArrayList;
    }

    @Test
    @DisplayName("Test addToFront method in case the array list is empty")
    void addToFrontTC1() throws EmptyCollectionException {
        UnorderedArrayList<Integer> unorderedArrayList = new UnorderedArrayList<>();

        unorderedArrayList.addToFront(2);

        assertEquals(unorderedArrayList.size(), 1);
        assertEquals(unorderedArrayList.getFirst(), 2);
        assertEquals(unorderedArrayList.getLast(), 2);
    }

    @Test
    @DisplayName("Test addToFront method")
    void addToFrontTC2() throws EmptyCollectionException {
        UnorderedArrayList<Integer> unorderedArrayList = new UnorderedArrayList<>();

        unorderedArrayList.addToFront(2);
        unorderedArrayList.addToFront(3);
        unorderedArrayList.addToFront(5);

        assertEquals(unorderedArrayList.size(), 3);
        assertEquals(unorderedArrayList.getFirst(), 5);
        assertEquals(unorderedArrayList.getLast(), 2);
    }

    @Test
    @DisplayName("Test addToRear method in case the array list is empty")
    void addToRearTC1() throws EmptyCollectionException {
        UnorderedArrayList<Integer> unorderedArrayList = new UnorderedArrayList<>();

        unorderedArrayList.addToRear(2);

        assertEquals(unorderedArrayList.size(), 1);
        assertEquals(unorderedArrayList.getFirst(), 2);
        assertEquals(unorderedArrayList.getLast(), 2);
    }

    @Test
    @DisplayName("Test if it removes all the occurrences of the element with value of 10")
    void removeAllTC1() throws EmptyCollectionException, ElementNotFoundException {
        UnorderedArrayList<Integer> unorderedArrayList = this.getUnorderedArrayList();

        unorderedArrayList.addToFront(10);
        unorderedArrayList.addToFront(10);

        unorderedArrayList.removeAll(10);

        assertEquals(99, unorderedArrayList.size());
        assertFalse(unorderedArrayList.contains(10));
    }

}
