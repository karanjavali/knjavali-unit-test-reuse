package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class Instructor extends Person {
	public Instructor() {
		type = 1;
	}

	public CourseMenu createCourseMenu(Course theCourse, int theLevel) {
		theCourseMenu = new HighLevelCourseMenu();
		return theCourseMenu;
	}

	public boolean showMenu() {
		super.showMenu();
		showAddButton();
		showViewButtons();
		showComboBoxes();
		showRadios();
		return ifLogout();
	}
}
