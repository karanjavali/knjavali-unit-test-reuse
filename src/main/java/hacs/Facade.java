package hacs;

import java.io.*;

public class Facade {
	public int userType;
	private Course theSelecteCourse = null;
	private int nCourseLevel = 0;
	ClassCourseList theCourseList;
	Person thePerson;

	public Facade() {
	}

	static public boolean login(UserInfoItem userInfoItem) {
		Login login = new Login();
		login.setModal(true);
		login.show();
		userInfoItem.strUserName = login.getUserName();
		userInfoItem.userType = login.getUserType();
		return login.isExit();
	}


	void addAssignment(Course theCourse) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0)/// student
		{
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}
		Assignment theAssignment = new Assignment();
		theAssignmentMenu.showMenu(theAssignment, thePerson);
		theCourse.addAssignment(theAssignment);
	}

	void viewAssignment(Assignment theAssignment) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0)/// student
		{
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}

		theAssignmentMenu.showMenu(theAssignment, thePerson);
	}


	void gradeSolution(Solution theSolution) {
		SolutionMenu solutionMenu = new SolutionMenu();
		solutionMenu.showMenu(theSolution);
	}

	void reportSolutions(Assignment theAssignment) {
		Solution theSolution;
		SolutionIterator theSolutionIterator;
		theSolutionIterator = theAssignment.getSolutionIterator();
		theSolution = (Solution) theSolutionIterator.next();
		while (theSolution != null) {
			theSolution.setReported(true);
			theSolution = (Solution) theSolutionIterator.next();
		}
	}
	void submitSolution(Assignment theAssignment, Solution theSolution) {
		theAssignment.addSolution(theSolution);
	}

	void remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder(thePerson.getCourseList());
	}

	void createUser(UserInfoItem userInfoItem) {
		if (userInfoItem.userType == UserInfoItem.USER_TYPE.Student) /// student
		{
			thePerson = new Student();
		} else /// instructor
		{
			thePerson = new Instructor();
		}
		thePerson.userName = userInfoItem.strUserName;
	}

	void createCourseList() {
		theCourseList = new ClassCourseList();
		theCourseList.initializeFromFile();
	}

	void attachCourseToUser() {
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("./src/main/java/hacs/UserCourse.txt"));
			String aline, strUserName, strCourseName;
			while ((aline = file.readLine()) != null) // not the EOF
			{
				strUserName = getUserName(aline);
				strCourseName = getCourseName(aline);
				if (strUserName.compareTo(thePerson.userName) == 0) /// the UserName mateches
				{
					theSelecteCourse = findCourseByCourseName(strCourseName);
					if (theSelecteCourse != null) /// Find the Course in the CourseList--->attach
					{
						thePerson.addCourse(theSelecteCourse);
					}
				}
			}
		} catch (Exception ee) {
			;
		}
	}

	private String getUserName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(0, Sep);
	}

	private String getCourseName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(Sep + 1, aline.length());
	}

	public boolean selectCourse() {
		CourseSelectDlg theDlg = new CourseSelectDlg();
		theSelecteCourse = theDlg.showDlg(thePerson.courseList);
		thePerson.currentCourse = theSelecteCourse;
		nCourseLevel = theDlg.nCourseLevel;
		return theDlg.isLogout();
	}

	public boolean courseOperation() {
		thePerson.createCourseMenu(theSelecteCourse, nCourseLevel);
		return thePerson.showMenu();
	}

	private Course findCourseByCourseName(String strCourseName) {
		CourseIterator Iterator = new CourseIterator(theCourseList);
		return (Course) Iterator.next(strCourseName);
	}

}