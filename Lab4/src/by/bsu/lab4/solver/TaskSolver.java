package by.bsu.lab4.solver;

import by.bsu.lab4.entity.Abiturient;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static by.bsu.lab4.constants.NumMarks.NUM_MARKS;

/**
 * Class to solve the given task
 * @author Alexandr Goncharov
 * @version 1.0
 *
 */
public class TaskSolver {
    private static final Logger logger = LogManager.getRootLogger();//корневой регистратор
    private static final Logger log = LogManager.getLogger(TaskSolver.class.getName());
    private static final Logger x = LogManager.getLogger("file");

    /**
     * Checks if an Abiturient has bad mark
     * @param original given Abiturient
     * @return true if Abiturient has bad mark, false if he doesn't
     */
    private boolean hasBadMark(Abiturient original) {
        for (int i = 0; i < NUM_MARKS; i++) {
            if (original.getMark(i) < 4) {
                return true;
            }
        }
        return false;
    }

    /**
     * Count average mark
     * @param original given Abiturient
     * @return average mark of an Abiturient
     */
    private double averageMark(Abiturient original) {
        double totalMark = 0;
        for (int i = 0; i < NUM_MARKS; i++) {
            totalMark = totalMark + original.getMark(i);
        }
        double result = totalMark / NUM_MARKS;
        return result;
    }

    /**
     * Method to get all Abiturients with bad marks
     * @param original array of Abiturients
     * @return List of Abiturients with bad marks
     */
    public List<Abiturient> badMarks(Abiturient[] original) {
        log.info("Applying badMarks method of TaskSolver class");
        if(original==null) {
            throw new  NullPointerException("Null arrays cant be handled");
        }
        List<Abiturient> result = new ArrayList<>();
        for (int i = 0; i < original.length; i++) {
            if (hasBadMark(original[i])) {
                result.add(original[i]);
            }
        }
        return result;
    }

    /**
     * Method to get all Abiturients with average mark higher than given
     * @param original array of Abiturients
     * @param givenMark a mark to compare with
     * @return List of Abiturients with average mark higher than given
     */
    public List<Abiturient> higherAverageMark(Abiturient[] original, double givenMark) {
        log.info("Applying higherAverageMark method of TaskSolver class");
        if(original==null)
            throw new NullPointerException("Null arrays cant be handled");
        if(givenMark<1||givenMark>10)
            throw new IllegalArgumentException("Mark must be between 1 and 10");
        List<Abiturient> result = new ArrayList<>();
        for (int i = 0; i < original.length; i++) {
            if (averageMark(original[i]) > givenMark)
                result.add(original[i]);
        }
        return result;
    }

    /**
     * Method to get Abiturients with the highest average marks
     * @param original array of Abiturients
     * @param number amount of students to get
     * @return List of given amount of Abiturients with the highest average marks
     */
    public List<List<Abiturient>> bestAmountOfStudents (Abiturient[] original, int number) {
        log.info("Applying bestAmountOfStudents method of TaskSolver class");
        if(original==null)
            throw new NullPointerException("Null arrays cant be handled");
        if(number<0||number>original.length)
            throw new IllegalArgumentException("Number of students must be positive and in range of amount of Abiturients");
        Abiturient[] originalCopy = new Abiturient[original.length];
        double[] averageMark = new double[original.length];
        List<List<Abiturient>> resultList=new ArrayList<>();
        List<Abiturient> result = new ArrayList<>();
        double halfPass = 0;
        //подсчитывание среднего балла для каждого студента
        for (int i = 0; i < original.length; i++) {
            originalCopy[i] = new Abiturient(original[i]);
            averageMark[i] = averageMark(original[i]);
        }
        // сортировка по оценкам
        for (int i = 0; i < originalCopy.length - 1; i++) {
            for (int j = i + 1; j < originalCopy.length; j++) {
                if (averageMark[i] < averageMark[j]) {
                    Abiturient temp = originalCopy[i];
                    originalCopy[i] = originalCopy[j];
                    originalCopy[j] = temp;
                    double tempNum = averageMark[i];
                    averageMark[i] = averageMark[j];
                    averageMark[j] = tempNum;
                }
            }
        }
        for (int i = 0; i < number; i++) {
            result.add(originalCopy[i]);
        }
        resultList.add(result);
        List<Abiturient> halfPassList=new ArrayList<>();
        //добавление с полупроходным
        int status = 0;
        int i = number;
        for (int j = 0; j < NUM_MARKS; j++) {
            halfPass = halfPass + result.get(result.size() - 1).getMark(j);
        }
        halfPass=halfPass/NUM_MARKS;
        while (status != 1&&i<original.length) {
            if (averageMark[i] == halfPass) {
                halfPassList.add(originalCopy[i]);
                i++;
            }
            else status = 1;
        }
        resultList.add(halfPassList);
        return resultList;
    }

    /**
     * Method to convert List of Abiturients  to String[]
     * @param original list of abiturients
     * @return array of Strings
     */
    public String[] abListToString(List<Abiturient> original)
    {
        String result[]=new String[original.size()];
        for(int i=0;i<original.size();i++)
        {
            result[i]=original.get(i).toString();
        }
        return result;
    }
}
