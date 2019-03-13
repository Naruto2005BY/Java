package by.bsu.lab3.solver;


import by.bsu.lab3.util.Services;

/**
 * Class used for completing the task
 * @author Alezandr Goncharov
 * @version 1.0
 */
public class TaskSolver extends Services
{
    /**
     * Method used to find number with the smallest amount of different digits
     * @param values array of numbers
     * @return number with smallest amount of different digits from array
     */
    public double findValueWithMinSameChars(double[] values)
    {
        int[] countArray = new int[values.length];
        int maxValueOfDifferentDigitsIndex = 0;
        for (int i = 0; i < values.length; i++)
        {
            int count = 0;
            int[] valueElements = getCharsOfNumber(values[i]);
            int[] checkedElements=new int[valueElements.length];
            for (int j = 0; j < valueElements.length; j++)
            {

                for (int k = j + 1; k < valueElements.length ; k++ ) {

                    int status = 0;
                    for (int l = 0; l < j; l++)
                    {

                        if (valueElements[j]==checkedElements[l]) status = 1;

                    }
                    if (status == 0) {

                        if (valueElements[j]==valueElements[k])
                        {
                            count++;
                        }
                    }
                }
                checkedElements[j]=valueElements[j];
            }
            int totalCount=getCountsOfDigits(values[i]);
            countArray[i] = totalCount-count;
        }
        int maxValueOfDifferentDigits = countArray[0];
        for (int j = 0; j < countArray.length; j++)
        {

            if(countArray[j] < maxValueOfDifferentDigits)
            {
                maxValueOfDifferentDigitsIndex = j;
                maxValueOfDifferentDigits = countArray[j];
            }
        }
    return values[maxValueOfDifferentDigitsIndex];
    }
}