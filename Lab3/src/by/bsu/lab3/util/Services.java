package by.bsu.lab3.util;

import java.math.BigDecimal;
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
     * @param size size of array
     * @return array
     */
    public double[] getArrayFromConsole(int size) {
        double[] array = new double[size];
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
     * @param given given number
     * @return amount of digits in a number
     */
    protected int getCountsOfDigits(double given)
    {
        double number=Math.abs(given);
        BigDecimal bd=new BigDecimal(Double.toString(number));
        bd=bd.stripTrailingZeros();
        if(bd.scale()<1) {
            return bd.precision() - bd.scale();
        }
        else return bd.precision();
    }

    /**
     * method used to divide the number into an array of its digits
     * @param given number
     * @return array formed by digits
     */
    protected int[] getCharsOfNumber(double given)
    {
        double number=Math.abs(given);
        int status=0;
        while(status!=1)
        {
            BigDecimal bd=new BigDecimal(Double.toString(number));
            bd=bd.stripTrailingZeros();
            if(bd.scale()<1)
            {
                status=1;
            }
            else {
                if (bd.scale() == 0) status = 1;
                else
                {
                    BigDecimal numberBd=BigDecimal.valueOf(number);
                    BigDecimal ten=BigDecimal.valueOf(10);
                    numberBd=numberBd.multiply(ten);
                    number=numberBd.doubleValue();
                }
            }
        }
        int noDecimalNumber=(int)number;
        int[] elements = new int[getCountsOfDigits(noDecimalNumber)];
        for (int i = 0; i < elements.length ; i++)
        {

            elements[elements.length - i - 1]=noDecimalNumber%10;
            noDecimalNumber/= 10;
        }

        return elements;

    }
}