package hacs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Karan Navin Javali
 */
class TestStudent {
    Student studentObj = new Student();

    @Test
    void createCourseMenuTest() {
        Assertions.assertEquals(0,studentObj.type);
    }

    @Test
    void showMenuTestTest() {
        CourseMenu courseMenu = studentObj.createCourseMenu(new Course("SER 515", 0), 0);
        Assertions.assertTrue(courseMenu instanceof HighLevelCourseMenu);
    }
}