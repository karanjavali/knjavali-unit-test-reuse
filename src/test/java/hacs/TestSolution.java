package hacs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestSolution {

    Solution solutionObj = new Solution();

    @Test
    void toStringTest() {
        solutionObj.theAuthor = "Karan";
        solutionObj.solutionFileName = "File";
        solutionObj.theGrade = 5;
        Assertions.assertEquals("Karan  File Grade=5  not reported", solutionObj.toString());
    }

    @Test
    void getGradeStringTest() {
        Assertions.assertEquals("-1", solutionObj.getGradeString());
    }

    @Test
    void getGradeIntTest() {
        Assertions.assertEquals(0, solutionObj.getGradeInt());
    }

    @Test
    void setReportedTest() {
        solutionObj.setReported(true);
        Assertions.assertEquals(true,solutionObj.reported);
    }

    @Test
    void isReportedTest() {
        solutionObj.setReported(true);
        Assertions.assertEquals(true,solutionObj.isReported());
    }

}
