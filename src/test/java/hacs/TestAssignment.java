package hacs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author Karan Navin Javali
 */
class TestAssignment {

    Assignment obj = new Assignment();

    @Test
    void setDueDateTest() {
        Date date = new Date();
        obj.setDueDate(date);
        Assertions.assertEquals(date,obj.dueDate);
    }

    @Test
    void setAssSpecTest() {
        String spec = "123";
        obj.setAssSpec(spec);
        Assertions.assertEquals("123",obj.assSpec);
    }

    @Test
    void isOverDueTest() {
        Date today = new Date();
        Assertions.assertEquals(today.after(obj.dueDate),obj.isOverDue());
    }

    @Test
    void addSolutionTest1() {
        Assertions.assertTrue(obj.addSolution() instanceof Solution);
    }

    @Test
    void addSolutionTest2() {
        Solution solution = new Solution();
        obj.addSolution(solution);
        Assertions.assertEquals(solution,obj.theSolutionList.get(obj.theSolutionList.size()-1));
    }


    @Test
    void getSolutionTest() {
    }

    @Test
    void getSugSolutionTest() {
        Assertions.assertEquals(obj.suggestSolution,obj.getSugSolution());
    }

    @Test
    void getSolutionIteratorTest() {
    }

    @Test
    void toStringTest() {
        Assertions.assertEquals(obj.assName,obj.toString());
    }

    @Test
    void getDueDateStringTest() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        Assertions.assertEquals(dateFormat.format(obj.dueDate),obj.getDueDateString());
    }


}