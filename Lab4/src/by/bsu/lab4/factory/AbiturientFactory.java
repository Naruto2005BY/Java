package by.bsu.lab4.factory;

import by.bsu.lab4.entity.Abiturient;
//import by.bsu.lab4.util.InputAbiturient;

import java.util.Arrays;
import java.util.List;

/**
 * Class to produce arrays of Abiturients
 * @author Alexandr Goncharov
 * @version 1.0
 */
public class AbiturientFactory {
    //static InputAbiturient given=new InputAbiturient();
   /* public Abiturient[] getSomeAbiturients (int size)
    {
        Abiturient[] result=new Abiturient[size];
        for(int i=0;i<size;i++)
        {
            result[i]=given.iAbiturient();
        }
        return result;
    }
   */

    /**
     * method to add Abiturient to existing array
     * @param original original array
     * @param toAdd Abiturient to be added to array
     * @return array with new Abiturient
     */
    public Abiturient[] addToAbiturientArray(Abiturient[] original, Abiturient toAdd) {
        if (original == null) {
            throw new NullPointerException("Null arrays should be handled in another method");
        }
        if (toAdd == null) {
            throw new NullPointerException("Null objects cant be added to array");
        }
        Abiturient[] result = Arrays.copyOf(original, original.length + 1);
        result[original.length] = new Abiturient(toAdd);
        return result;
    }

    /**
     * Method to add Abiturient to empty array
     * @param toAdd Abiturient to be added
     * @return array with added Abiturient
     */
    public Abiturient[] addToEmptyAbiturientArray(Abiturient toAdd) {
        Abiturient[] result = new Abiturient[1];
        result[0] = new Abiturient(toAdd);
        return result;
    }
    /*public boolean equalLists(List<Abiturient> first, List<Abiturient> second)
    {
        if(first==null&&second==null)return true;
        if(first.size()!=second.size())return false;
        for(int i=0;i<first.size();i++)
        {
            if(first.get(i).equals(second.get(i))==false)return false;
        }
        return true;
    }*/
}

