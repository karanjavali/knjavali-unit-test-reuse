package hacs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Karan Navin Javali
 */
class TestSolutionIterator {
    SolutionList solutionListObj = new SolutionList();
    Solution solutionObj = new Solution();
    @Test
    void moveToHeadTest() {
        solutionListObj.add(solutionObj);
        SolutionIterator solutionIteratorObj = new SolutionIterator(solutionListObj);
        solutionIteratorObj.moveToHead();
        Assertions.assertEquals(-1,solutionIteratorObj.currentSolutionNumber);

    }

    @Test
    void hasNextTest() {
        solutionListObj.add(solutionObj);
        SolutionIterator solutionIteratorObj = new SolutionIterator(solutionListObj);
        Assertions.assertTrue(solutionIteratorObj.hasNext());
    }

    @Test
    void nextTest1() {
        solutionListObj.add(solutionObj);
        SolutionIterator solutionIteratorObj = new SolutionIterator(solutionListObj);
        Assertions.assertNotNull(solutionIteratorObj.next());
    }

    @Test
    void nextTest2() {
        solutionObj.theAuthor = "Karan";
        solutionListObj.add(solutionObj);
        SolutionIterator solutionIteratorObj = new SolutionIterator(solutionListObj);
        Assertions.assertNotNull(solutionIteratorObj.next("Karan"));
    }

    @Test
    void removeTest() {
        solutionListObj.add(solutionObj);
        SolutionIterator solutionIteratorObj = new SolutionIterator(solutionListObj);
        solutionIteratorObj.next();
        solutionIteratorObj.remove();
        Assertions.assertEquals(0, solutionIteratorObj.solutionlist.size());
    }
}