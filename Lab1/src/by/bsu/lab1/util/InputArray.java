package by.bsu.lab1.util;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class to input array of given size
 * @author Alexandr Goncharov
 * @version 1.0
 */
public class InputArray {
    Scanner input = new Scanner(System.in);
    /**
     * Class to return array of given size
     * @param size given size
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
}
