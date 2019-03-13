/*
package by.bsu.lab4.util;

import java.util.InputMismatchException;
import java.util.Scanner;

*/
/**
 * class to input integer
 * @author Alexandr Goncharov
 * @version 1.0
 *//*

public class InputInteger {
    Scanner input=new Scanner(System.in);

    */
/**
     * method to input integer
     * @return inputed integer
     *//*

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
                System.out.println("Invalid input.Please, reenter your integer");
                input.nextLine();
            }
        }
        return integer;
    }

}
*/
