package by.bsu.lab1.solver;

import java.util.Stack;

/**
 * Class to find the numbers which can be divided by 5 and 7
 * @author Alexandr Goncharov
 * @version 1.0
 */
public class TaskSolver {
    /**
     * Class to form stack with numbers which can be divided by 5 and 7
     * @param array original array of numbers
     * @return Stack with needed numbers
     */
    public Stack<Integer> Stack(int[] array)
    {
       Stack<Integer> stack = new Stack<>();
       for(int i=0;i<array.length;i++)
       {
           if(array[i]%35==0)
           {
               stack.push(array[i]);
           }
       }
       return stack;
    }

    /**
     * Prints the needed numbers
     * @param stack stack with numbers
     */
    public void Output(Stack<Integer> stack)
    {
        System.out.println("Numbers which can be divided by 5 and 7 are:");
        while(!(stack.isEmpty()))
        {
            System.out.println(stack.pop());
        }
    }
}
