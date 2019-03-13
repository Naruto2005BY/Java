package by.bsu.lab3;

import by.bsu.lab3.util.Services;
import by.bsu.lab3.solver.TaskSolver;

/**
 * Main class
 * @author Alexandr Goncharov
 * @version 1.0
 */

public class Main {

    static Services services=new Services();
    static TaskSolver solve = new TaskSolver();


    public static void main(String[] args) {
        int size=services.getInteger();
        double[] array=services.getArrayFromConsole(size);
        double result=solve.findValueWithMinSameChars(array);
        System.out.println("Value with smallest amount of different digits: "+ result);

    }
}