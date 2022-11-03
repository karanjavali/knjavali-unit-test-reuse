package hacs;

import java.util.*;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 * 
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 */

abstract public class Person {
	int type = 0;
	String userName;
	ClassCourseList courseList;
	CourseMenu theCourseMenu;
	Course currentCourse;
	Assignment currentAssignment;

	public Person() {
		courseList = new ClassCourseList();
	}

	abstract public CourseMenu createCourseMenu(Course theCourse, int theLevel);

	public void showAddButton() {
		theCourseMenu.showAddButtons();
	}

	public void showViewButtons() {
		theCourseMenu.showViewButtons();
	}

	public void showComboBoxes() {
		theCourseMenu.showComboBoxes();
	}

	public void showRadios() {
		theCourseMenu.showRadios();
	}

	public void show() {
	}

	public boolean ifLogout() {
		return theCourseMenu.ifLogout();
	}

	public boolean showMenu() {
		Iterator theIter = currentCourse.assignmentList.iterator();
		theCourseMenu.theCourse = currentCourse;
		Assignment theAssignment;
		while (theIter.hasNext()) {
			theAssignment = (Assignment) theIter.next();
			theCourseMenu.assignmentComboBox.addItem(theAssignment);
		}
		return false;
	}

	public ClassCourseList GetCourseList() {
		return courseList;
	}

	public void AddCourse(Course theCourse) {
		courseList.add(theCourse);
	}
}
