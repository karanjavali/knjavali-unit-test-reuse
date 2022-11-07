package hacs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Karan Navin Javali
 */
class TestListIterator {
    @Test
    void hasNextTest() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(5);
        ListIterator listIteratorObj = new ListIterator(list);
        Assertions.assertTrue(listIteratorObj.hasNext());
    }

    @Test
    void nextTest() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(5);
        ListIterator listIteratorObj = new ListIterator(list);
        Assertions.assertNotNull(listIteratorObj.next());
    }

    @Test
    void removeTest() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(5);
        ListIterator listIteratorObj = new ListIterator(list);
        listIteratorObj.next();
        listIteratorObj.remove();
        Assertions.assertEquals(0, listIteratorObj.theList.size());
    }
}