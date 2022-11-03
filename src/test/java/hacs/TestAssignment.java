package hacs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author Karan Navin Javali
 */
class TestAssignment {

    Assignment obj = new Assignment();

    @Test
    void setDueDate() {
        Date date = new Date();
        obj.setDueDate(date);
        Assertions.assertEquals(date,obj.dueDate);
    }

    @Test
    void setAssSpec() {
        String spec = "123";
        obj.setAssSpec(spec);
        Assertions.assertEquals("123",obj.assSpec);
    }

    @Test
    void isOverDue() {
    }

    @Test
    void addSolution() {
    }

    @Test
    void testAddSolution() {
    }

    @Test
    void submitSolution() {
    }

    @Test
    void getSolutionList() {
    }

    @Test
    void getSolution() {
    }

    @Test
    void getSugSolution() {
    }

    @Test
    void getSolutionIterator() {
    }

    @Test
    void testToString() {
    }

    @Test
    void getDueDateString() {
    }

    @Test
    void accept() {
    }
}