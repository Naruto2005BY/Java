package by.bsu.lab3.util;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class with all methods needed for solving the task
 * @author Alexandr Goncharov
 * @version 1.0
 *
 *
 */
public class Services
{
    Scanner input = new Scanner(System.in);

    /**
     * Class to input a correct integer
     * @return integer
     */
    public int getInteger()
    {
        System.out.println("Input your number");
        int integer=-1;
        boolean isInvalid = true;
        while(isInvalid) {
            try {
                integer = input.nextInt();

                isInvalid = false;
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input.Please, reenter integer");
                input.nextLine();
            }
        }
        return integer;
    }

    /**
     * method used for inputting an array
     * @return array
     */
    public int[] getArrayFromConsole(int size) {
        int[] array = new int[size];
        boolean isInvalid = true;
        while(isInvalid){
            try{
                for(int i=0;i<size;i++){
                    array[i]=input.nextInt();
                }
                isInvalid = false;
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input.Please, reenter array");
                input.nextLine();
            }
        }
        return array;
    }

    /**
     * method used  for counting digits in a given number
     * @param number given number
     * @return amount of digits in a number
     */
    protected int getCountsOfDigits(int number)
    {
        int count = (number == 0) ? 1 : 0;
        while (number != 0)
        {
            count++;
            number /= 10;
        }
        return count;
    }

    /**
     * method used to divide the number into an array of its digits
     * @param number given number
     * @return array formed by digits
     */
    protected int[] getCharsOfInteger(int number)
    {
        int[] elements = new int[getCountsOfDigits(number)];
        for (int i = 0; i < elements.length ; i++)
        {

            elements[elements.length - i - 1] =  number % 10;
            number /= 10;
        }

        return elements;

    }
}