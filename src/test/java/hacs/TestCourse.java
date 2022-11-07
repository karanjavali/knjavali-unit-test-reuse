package hacs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Karan Navin Javali
 */
class TestCourse {
    Course courseObj = new Course("SER 515",0);
    @Test
    void addAssignmentTest() {
        courseObj.addAssignment(new Assignment());
        Assertions.assertEquals(1, courseObj.assignmentList.size());
    }

    @Test
    void toStringTest() {
        Assertions.assertEquals("SER 515",courseObj.toString());
    }

}