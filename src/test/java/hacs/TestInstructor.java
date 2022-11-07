package hacs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Karan Navin Javali
 */
class TestInstructor {

    Instructor instructorObj = new Instructor();
    @Test
    void createCourseMenuTest() {
        CourseMenu courseMenu = instructorObj.createCourseMenu(new Course("SER 515", 1), 1);
        Assertions.assertTrue(courseMenu instanceof HighLevelCourseMenu);
    }

}