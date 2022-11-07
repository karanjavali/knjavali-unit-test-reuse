package hacs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Karan Navin Javali
 */
class TestClassCourseList {

    @Test
    void initializeFromFileTest() throws IOException {
        ClassCourseList classCourseListObj = new ClassCourseList();
        classCourseListObj.initializeFromFile();
        BufferedReader file = new BufferedReader(new FileReader("./src/main/java/hacs/CourseInfo.txt"));
        int i = 0;
        while (file.readLine() != null) {
            i += 1;
        }
        assertEquals(i, classCourseListObj.size());


    }

    @Test
    void findCourseByCourseNameTest() {
        ClassCourseList classCourseListObj = new ClassCourseList();
        classCourseListObj.add(new Course("SER 515",0));
        Assertions.assertNotNull(classCourseListObj.findCourseByCourseName("SER 515"));
    }
}