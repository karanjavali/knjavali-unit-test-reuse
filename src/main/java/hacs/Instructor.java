package hacs;

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
