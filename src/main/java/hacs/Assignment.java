package hacs;

/**
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 */

import java.util.*;
import java.text.DateFormat;

public class Assignment {

  protected String assName;
  protected String strAssignmentFilename;
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

  public void submitSolution() {
  }

  public void getSolutionList() {
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
    SolutionIterator theSolutionIterator = new SolutionIterator(theSolutionList);
    return theSolutionIterator;
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

