package by.bsu.lab3.solver;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskSolverTest {

    static TaskSolver solver;

    @BeforeAll
    static void setUp() {
        solver=new TaskSolver();
    }
    @Test
    void solveUsualArray() {
        double[] array={1112,1234,12456,2220,2222};
        double expected=2222;
   //     TaskSolver solve=new TaskSolver();
        double actual=solver.findValueWithMinSameChars(array);
        assertEquals(expected,actual);


    }

    @Test
     void solveBigNumSameDigits(){

        double[] array={1100101,12345,12,130};
        double expected=1100101;
        TaskSolver solve=new TaskSolver();
        double actual=solve.findValueWithMinSameChars(array);
        assertEquals(expected,actual);
    }

    @Test
    void solveNegativeNumber(){
        double[] array={-8558,9991};
        double expected=-8558;
        TaskSolver solve=new TaskSolver();
        double actual=solve.findValueWithMinSameChars(array);
        assertEquals(expected,actual);
    }
    @Test
    void solveNegativeArray(){
        double[] array={-4355,-12341,-12213,-788778,-9919};
        double expected=-788778;
        TaskSolver solve=new TaskSolver();
        double actual=solve.findValueWithMinSameChars(array);
        assertEquals(expected,actual);
    }
    @Test
    void testWithOnlyDoubles() {
        double[] array={1112.021,1234.130,12456.98,2220.28,2222.22};
        double expected=2222.22;
        TaskSolver solve=new TaskSolver();
        double actual=solve.findValueWithMinSameChars(array);
        assertEquals(expected,actual);
    }
    @Test
    void solveMixedArray() {
        double[] array={-1112,1112,-5555,232783};
        double expected=-5555;
        TaskSolver solve=new TaskSolver();
        double actual=solve.findValueWithMinSameChars(array);
        assertEquals(expected,actual);
    }


}