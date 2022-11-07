package hacs;

public class Student extends Person {

	public Student() {
		type = 0;
	}

	public CourseMenu createCourseMenu(Course theCourse, int theLevel) {

		if (theLevel == 0) {
			theCourseMenu = new HighLevelCourseMenu();
		} else {
			theCourseMenu = new LowLevelCourseMenu();
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
