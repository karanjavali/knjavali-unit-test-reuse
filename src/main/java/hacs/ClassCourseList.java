package hacs;

import java.util.ArrayList;
import java.io.*;


public class ClassCourseList extends ArrayList<Course> {

	public ClassCourseList() {
	}

	void initializeFromFile() {
		try {
			BufferedReader file;
			String strCourseName;
			file = new BufferedReader(new FileReader("./src/main/java/hacs/CourseInfo.txt"));
			while ((strCourseName = file.readLine()) != null) {
				Course theCourse;
				theCourse = new Course(strCourseName, 0);
				add(theCourse);
			}
		} catch (Exception ee) {
			/* Ignore EXCEPTIONNAME. */
		}
	}

	Course findCourseByCourseName(String courseName) {
		for (Course course : this) {
			Course theCourse;
			theCourse = course;
			if (theCourse.courseName.compareTo(courseName) == 0)
				return theCourse;
		}
		return null;
	}

}
