/*
package by.bsu.lab4.util;

import by.bsu.lab4.entity.Abiturient;

import java.util.Scanner;

import static by.bsu.lab4.constants.NumMarks.NUM_MARKS;

public class InputAbiturient {
    static InputInteger integer=new InputInteger();
    Scanner input=new Scanner(System.in);
    public Abiturient iAbiturient()
    {
        Abiturient result=new Abiturient();
        System.out.println("Inputting new abiturient");
        System.out.println("Enter id:");
        result.setId(integer.getInteger());
        System.out.println("Enter first name: ");
        result.setFirstName(input.nextLine());
        System.out.println("Enter middle name: ");
        result.setMiddleName(input.nextLine());
        System.out.println("Enter last name: ");
        result.setLastName(input.nextLine());
        System.out.println("Enter address");
        result.setAddress(input.nextLine());
        System.out.println("Enter marks: ");
        for(int i=0;i<NUM_MARKS;i++)
        {
            result.setMark(i,integer.getInteger());
        }
        return result;
    }
}
*/
