package hacs;

import java.util.*;


public class Course {
  String courseName;
  public ArrayList<Assignment> assignmentList = new ArrayList<>();
  int numOfAss;
  int courseLevel;


  public Course(String strCourse, int theLevel) {
    this.courseName = strCourse;

    this.courseLevel = theLevel;
    this.numOfAss = 0;
  }
  
  public void addAssignment(Assignment newAss) {
    assignmentList.add(newAss);
  }
  
  public String toString() {
    return courseName;
  }
  
  void accept(NodeVisitor visitor) {
    visitor.visitCourse(this);
  }
}
