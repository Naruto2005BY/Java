package by.bsu.lab1;

import by.bsu.lab1.solver.TaskSolver;
import by.bsu.lab1.util.InputInteger;
import by.bsu.lab1.util.InputArray;

import java.util.Stack;

/**
 * Main class
 */
public class Main {
    static InputInteger inputInteger=new InputInteger();
    static InputArray input=new InputArray();
    static  TaskSolver ts = new TaskSolver();

    public static void main(String[] args) {
        int size=inputInteger.getInteger();
        int array[]=input.getArrayFromConsole(size);
        Stack<Integer> stack = ts.Stack(array);
        ts.Output(stack);
    }
}
