package hacs;

import java.util.Iterator;
import java.util.*;

public class ReminderVisitor extends NodeVisitor {

	Reminder mReminder;

	public ReminderVisitor() {
	}

	public ReminderVisitor(Reminder reminder) {
		mReminder = reminder;
	}

	public void visitFacade(Facade facade) {
		CourseIterator courseList = new CourseIterator(facade.theCourseList);
		while (courseList.hasNext()) {
			Course course = (Course) courseList.next();
			course.accept(this);
		}
	}

	public void visitCourse(Course course) {
		Iterator<Assignment> assignmentList = course.assignmentList.listIterator();
		while (assignmentList.hasNext()) {
			Assignment assignment = (Assignment) assignmentList.next();
			assignment.accept(this);
		}
	}

	public void visitAssignment(Assignment assignment) {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		int ntoday = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(assignment.dueDate);
		int nDueDate = calendar.get(Calendar.DAY_OF_YEAR);
		if (nDueDate <= (ntoday + 1) && nDueDate >= ntoday) /// upcoming
		{
			mReminder.listUpcoming.add("today is " + today.toString() + " " + assignment.assName + " Due Date is "
					+ assignment.getDueDateString());
		}
		if (nDueDate < ntoday) {
			mReminder.listOverdue.add(assignment.assName + " Due Date is " + assignment.getDueDateString());
		}

	}

}
