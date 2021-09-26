package Lists.UnorderedList;

import Exceptions.EmptyCollectionException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class TestUnorderedArrayList {

    private UnorderedArrayList<Integer> getUnorderedArrayList() {
        return null;
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


}
