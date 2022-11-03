package hacs;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 * 
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 */

public class Student extends Person {

	public Student() {
		type = 0;
	}

	public CourseMenu createCourseMenu(Course theCourse, int theLevel) {

		if (theLevel == 0) {
			theCourseMenu = new HighLevelCourseMenu();
		} else {
			theCourseMenu = new lowLevelCourseMenu();
		}
		return theCourseMenu;
	}

	@Override
	public boolean showMenu() {
		super.showMenu();
		showViewButtons();
		showComboBoxes();
		showRadios();
		return ifLogout();
	}
}
