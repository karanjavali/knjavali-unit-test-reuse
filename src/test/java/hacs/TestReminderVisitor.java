package hacs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author Karan Navin Javali
 */
class TestReminderVisitor {

    ReminderVisitor r = new ReminderVisitor();


    @Test
    void visitAssignmentTest() {
        ReminderVisitor reminderVisitor = new ReminderVisitor(new Reminder());
        Assignment assignment = new Assignment();
        assignment.assName = "SER 515";
        assignment.dueDate = new Date();
        reminderVisitor.visitAssignment(assignment);
        Assertions.assertNotNull(reminderVisitor.mReminder.listUpcoming);
    }
}