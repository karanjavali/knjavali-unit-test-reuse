package hacs;

import java.awt.*;

public class lowLevelCourseMenu extends CourseMenu {

	public lowLevelCourseMenu() {
	}

	void showMenu(Course theCourse) {
	}

	void showAddButtons() {
		assignmentAddButton.addActionListener(this::assignmentAddButtonActionPerformed);
		assignmentAddButton.setText("Add");
		assignmentAddButton.setBounds(new Rectangle(389, 54, 79, 29));
		optionAddButton.setText("Add");
		optionAddButton.setBounds(new Rectangle(390, 125, 79, 29));
		this.getContentPane().add(assignmentAddButton, null);
		this.getContentPane().add(optionAddButton, null);
	}

	void showRadios() {
		assignmentRadio.setText("Assignment");
		assignmentRadio.setBounds(new Rectangle(21, 55, 103, 26));
		this.getContentPane().add(assignmentRadio, null);
		optionRadio.setText("LowLevelExperiment");
		optionRadio.setBounds(new Rectangle(21, 128, 103, 26));
		this.getContentPane().add(optionRadio, null);
	}

	void showComboBoxes() {
		assignmentComboBox.setBounds(new Rectangle(140, 57, 126, 22));
		optionCombo.setBounds(new Rectangle(137, 127, 126, 22));
		this.getContentPane().add(assignmentComboBox, null);
		this.getContentPane().add(optionCombo, null);
		refresh();
	}

	void showViewButtons() {
		assignmentViewButton.setText("View");
		assignmentViewButton.setBounds(new Rectangle(290, 54, 79, 29));
		assignmentViewButton.addActionListener(this::AssignmentViewButton_actionPerformed);
		optionViewButton.setText("View");
		optionViewButton.setBounds(new Rectangle(290, 124, 79, 29));
		this.getContentPane().add(assignmentViewButton, null);
		this.getContentPane().add(optionViewButton, null);
	}

	void showLabel() {
		assignmentContentLabel.setText("AssigmentContent");
		assignmentContentLabel.setBounds(new Rectangle(23, 186, 432, 99));
		this.getContentPane().add(assignmentContentLabel, null);
	}
}
