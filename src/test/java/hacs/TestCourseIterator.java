package hacs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Karan Navin Javali
 */
class TestCourseIterator {

    CourseIterator courseIteratorObj = new CourseIterator();
    ClassCourseList classCourseListObj = new ClassCourseList();

    @Test
    void hasNextTest() {
        Course course = new Course("SER 515", 1);
        classCourseListObj.add(course);
        CourseIterator courseIterator = new CourseIterator(classCourseListObj);
        Assertions.assertTrue(courseIterator.hasNext());
    }

    @Test
    void nextTest1() {
        Course course = new Course("SER 515", 1);
        classCourseListObj.add(course);
        CourseIterator courseIteratorObj = new CourseIterator(classCourseListObj);
        assertNotNull(courseIteratorObj.next());
    }

    @Test
    void removeTest() {
        Course course = new Course("SER 515", 1);
        classCourseListObj.add(course);
        CourseIterator courseIteratorObj = new CourseIterator(classCourseListObj);
        courseIteratorObj.next();
        courseIteratorObj.remove();
        assertEquals(0, courseIteratorObj.theCourseList.size());
    }

    @Test
    void nextTest2() {
        Course course = new Course("SER 515", 1);
        classCourseListObj.add(course);
        CourseIterator courseIteratorObj = new CourseIterator(classCourseListObj);
        assertNotNull(courseIteratorObj.next("SER 515"));
    }
}