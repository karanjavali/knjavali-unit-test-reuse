package hacs;

import java.util.*;
import java.text.DateFormat;

public class Assignment {

  protected String assName;
  protected Date dueDate = new Date();
  protected String assSpec;
  protected SolutionList theSolutionList = new SolutionList();
  protected Solution suggestSolution = new Solution();



  public Assignment() {
  }

  public void setDueDate(Date theDueDate) {
    this.dueDate = theDueDate;
  }

  public void setAssSpec(String theSpec) {
    this.assSpec = theSpec;
  }

  public boolean isOverDue(){
    Date today;
    today = new Date();
    return today.after(this.dueDate);
  }

  public Solution addSolution() {
    return new Solution();
  }

  public void addSolution(Solution theSolution) {
    theSolutionList.add(theSolution);
  }



  /* return the solution of the give name
  */
  public Solution getSolution(String studentName) {
    SolutionIterator iterator = (SolutionIterator)theSolutionList.iterator();
    return (Solution)iterator.next(studentName);
  }

  public Solution getSugSolution() {
    return suggestSolution;
  }

  public SolutionIterator getSolutionIterator() {
    return new SolutionIterator(theSolutionList);
  }

  public String toString() {
    return assName;
  }

  public String getDueDateString() {
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    return  dateFormat.format(dueDate);
  }

  public void accept(NodeVisitor visitor) {
    visitor.visitAssignment(this);
  }
}

