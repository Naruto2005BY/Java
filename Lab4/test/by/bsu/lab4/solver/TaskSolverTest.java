package by.bsu.lab4.solver;

import by.bsu.lab4.entity.Abiturient;
import by.bsu.lab4.factory.AbiturientFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class TaskSolverTest {

    private static final Logger logger = LogManager.getRootLogger();//корневой регистратор

    private static final Logger log = LogManager.getLogger(TaskSolverTest.class.getName());

    private static final Logger x = LogManager.getLogger("file");
    Abiturient[] given;
    static TaskSolver solver;
    static AbiturientFactory abFactory;
    List<Abiturient>expectedList;

    @BeforeAll
    static void setUpOnce() {
        solver = new TaskSolver();
        abFactory=new AbiturientFactory();
    }


    @BeforeEach
    void setUp() {
        given=new Abiturient[0];
        //expectedList=new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void badMarks() {
        Abiturient petya=new Abiturient(1,"Peter","Vasilevich","Rodionov","+375291238015","Pushkina,14", new int[]{9,5,5,7,6});
        Abiturient sasha=new Abiturient(2,"Alexandr","Vitalevich","Ivanov","+375291238095","Melnikaite,10",new int[]{3,5,6,2,7});
        Abiturient oleg=new Abiturient(3,"Oleg","Mikhailovich","Gurko","+375291238013","Belova,72",new int[]{3,5,6,9,8});
        given=abFactory.addToAbiturientArray(given,petya);
        given=abFactory.addToAbiturientArray(given,sasha);
        given=abFactory.addToAbiturientArray(given,oleg);
        List<Abiturient> resultList=solver.badMarks(given);
        expectedList=Arrays.asList(sasha,oleg);
        log.info("Result list is: "+Arrays.toString(solver.abListToString(resultList)));
        log.info("Expected list is: "+Arrays.toString(solver.abListToString(expectedList)));
         assertTrue(resultList.equals(expectedList));
    }
    @Test
    void badMarksEmpty(){
        Abiturient petya=new Abiturient(1,"Peter","Vasilevich","Rodionov","+375291238000","Pushkina,14", new int[]{9,5,5,7,6});
        Abiturient sasha=new Abiturient(2,"Alexandr","Vitalevich","Ivanov","+375299008016","Melnikaite,10",new int[]{5,5,6,8,7});
        Abiturient oleg=new Abiturient(3,"Oleg","Mikhailovich","Gurko","+375331238010","Belova,72",new int[]{5,5,6,9,8});
        given=abFactory.addToAbiturientArray(given,petya);
        given=abFactory.addToAbiturientArray(given,sasha);
        given=abFactory.addToAbiturientArray(given,oleg);
        List<Abiturient> resultList=solver.badMarks(given);
        expectedList=new ArrayList<>();
        log.info("Result list is: "+Arrays.toString(solver.abListToString(resultList)));
        log.info("Expected list is: "+Arrays.toString(solver.abListToString(expectedList)));
        assertTrue(resultList.equals(expectedList));
    }
    @Test
    void higherAverageMarkSix() {
        Abiturient petya=new Abiturient(1,"Peter","Vasilevich","Rodionov","+375291234567","Pushkina,14", new int[]{8,8,8,7,7});
        Abiturient sasha=new Abiturient(2,"Alexandr","Vitalevich","Ivanov","+375291234568","Melnikaite,10",new int[]{7,7,7,8,8});
        Abiturient oleg=new Abiturient(3,"Oleg","Mikhailovich","Gurko","+375291234566","Belova,72",new int[]{6,6,6,6,6});
        given=abFactory.addToAbiturientArray(given,petya);
        given=abFactory.addToAbiturientArray(given,sasha);
        given=abFactory.addToAbiturientArray(given,oleg);
        List<Abiturient> resultList=solver.higherAverageMark(given,6);
        expectedList=Arrays.asList(petya,sasha);
        log.info("Result list is: "+Arrays.toString(solver.abListToString(resultList)));
        log.info("Expected list is: "+Arrays.toString(solver.abListToString(expectedList)));
        assertTrue(resultList.equals(expectedList));
    }
    @Test
    void higherAverageMarkDouble() {
        Abiturient petya=new Abiturient(1,"Peter","Vasilevich","Rodionov","+375291234567","Pushkina,14", new int[]{8,8,8,7,7});
        Abiturient sasha=new Abiturient(2,"Alexandr","Vitalevich","Ivanov","+375291234568","Melnikaite,10",new int[]{7,7,7,8,8});
        Abiturient oleg=new Abiturient(3,"Oleg","Mikhailovich","Gurko","+375291234566","Belova,72",new int[]{6,6,6,6,6});
        given=abFactory.addToAbiturientArray(given,petya);
        given=abFactory.addToAbiturientArray(given,sasha);
        given=abFactory.addToAbiturientArray(given,oleg);
        List<Abiturient> resultList=solver.higherAverageMark(given,7.5);
        expectedList=Arrays.asList(petya);
        log.info("Result list is: "+Arrays.toString(solver.abListToString(resultList)));
        log.info("Expected list is: "+Arrays.toString(solver.abListToString(expectedList)));
        assertTrue(resultList.equals(expectedList));
    }
    @Test
    void bestAmountOfStudents() {
        Abiturient petya=new Abiturient(1,"Peter","Vasilevich","Rodionov","+375297095757","Pushkina,14", new int[]{8,8,7,7,7});
        Abiturient sasha=new Abiturient(2,"Alexandr","Vitalevich","Ivanov","+375297095758","Melnikaite,10",new int[]{7,7,7,8,8});
        Abiturient oleg=new Abiturient(3,"Oleg","Mikhailovich","Gurko","+375297095759","Belova,72",new int[]{7,8,7,8,7});
        given=abFactory.addToAbiturientArray(given,petya);
        given=abFactory.addToAbiturientArray(given,sasha);
        given=abFactory.addToAbiturientArray(given,oleg);
        List<List<Abiturient>> actual=solver.bestAmountOfStudents(given,2);
        List<Abiturient> expectedList=new ArrayList<>();
        expectedList.add(petya);
        expectedList.add(sasha);
        log.info("Result list is: "+Arrays.toString(solver.abListToString(actual.get(0))));
        log.info("Expected list is: "+Arrays.toString(solver.abListToString(expectedList)));
        assertTrue(actual.get(0).equals(expectedList));
    }
    @Test
    void bestAmountOfStudentsHalfPass() {
        Abiturient petya=new Abiturient(1,"Peter","Vasilevich","Rodionov","+375297095757","Pushkina,14", new int[]{8,8,7,7,7});
        Abiturient sasha=new Abiturient(2,"Alexandr","Vitalevich","Ivanov","+375297095758","Melnikaite,10",new int[]{7,7,7,8,8});
        Abiturient oleg=new Abiturient(3,"Oleg","Mikhailovich","Gurko","+375297095759","Belova,72",new int[]{7,8,7,8,7});
        given=abFactory.addToAbiturientArray(given,petya);
        given=abFactory.addToAbiturientArray(given,sasha);
        given=abFactory.addToAbiturientArray(given,oleg);
        List<List<Abiturient>> actual=solver.bestAmountOfStudents(given,1);
        List<Abiturient> expectedList=new ArrayList<>();
        expectedList.add(sasha);
        expectedList.add(oleg);
        log.info("Result list is: "+Arrays.toString(solver.abListToString(actual.get(1))));
        log.info("Expected list is: "+Arrays.toString(solver.abListToString(expectedList)));
        assertTrue(actual.get(1).equals(expectedList));
    }
    @Test
    void badMarkCheckNullArray() {
        given = null;
        Throwable exception = assertThrows(NullPointerException.class, () -> solver.badMarks(given));
        log.error("Null Array error", exception);
        assertEquals("Null arrays cant be handled",exception.getMessage());
    }

}