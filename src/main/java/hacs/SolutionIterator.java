package hacs;

import java.util.Iterator;

public class SolutionIterator implements Iterator {
  SolutionList solutionlist;

  int currentSolutionNumber = -1;

  public SolutionIterator() {
  }
  public SolutionIterator(SolutionList theSolutionList) {
    solutionlist = theSolutionList;
    moveToHead();
  }

  public void moveToHead()
  {
    currentSolutionNumber =- 1;
  }

  public boolean hasNext()
  {
    if (currentSolutionNumber >= solutionlist.size()-1)
      return false;
    else
      return true;
  }
  public Object next()
  {
    if (hasNext()) {
      currentSolutionNumber++;
      return solutionlist.get(currentSolutionNumber);
    } else {
      return null;
    }
  }

  public Object next(String userName)
  {
    Solution theSolution;
    theSolution = (Solution)next();
    while(theSolution != null) {
      if(userName.compareTo(theSolution.theAuthor) == 0) {
        return theSolution;
      }
      theSolution = (Solution)next();
    }
    return null;
  }

  public void remove() {
    solutionlist.remove(currentSolutionNumber);
  }


}
