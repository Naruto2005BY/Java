package by.bsu.lab4.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class AbiturientTest {
    private static final Logger logger = LogManager.getRootLogger();//корневой регистратор
    private static final Logger log = LogManager.getLogger(AbiturientTest.class.getName());
    private static final Logger x = LogManager.getLogger("file");

    @Test
    void setMarkCheckException() {
        Abiturient sasha = new Abiturient(2, "Alexandr", "Vitalevich", "Ivanov","+375294545454", "Melnikaite,10", new int[]{3, 5, 6, 2, 7});
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> sasha.setMark(2, 0));
        log.error("Wrong mark error", exception);
        assertEquals("Mark should be between 1 and 10", exception.getMessage());
    }


    @Test
    void notEqualAbiturients() {
        Abiturient petya = new Abiturient(1, "Peter", "Vasilevich", "Rodionov","+375294545454", "Pushkina,14", new int[]{9, 5, 5, 7, 6});
        Abiturient sasha = new Abiturient(2, "Alexandr", "Vitalevich", "Ivanov","+375294545455", "Melnikaite,10", new int[]{3, 5, 6, 2, 7});
        assertFalse(petya.equals(sasha));
    }

    @Test
    void equalAbiturients() {
        Abiturient petya1 = new Abiturient(1, "Peter", "Vasilevich", "Rodionov","+375293456226", "Pushkina,14", new int[]{9, 5, 5, 7, 6});
        Abiturient petya2 = new Abiturient(1, "Peter", "Vasilevich", "Rodionov","+375293456226", "Pushkina,14", new int[]{9, 5, 5, 7, 6});
        assertTrue(petya1.equals(petya2));
    }

    @Test
    void abiturientToString() {
        Abiturient sasha = new Abiturient(2, "Alexandr", "Vitalevich", "Ivanov","+375294097575", "Melnikaite,10", new int[]{3, 5, 6, 2, 7});
        log.info(sasha.toString());
        assertEquals(sasha.toString(), "id: 2 name: Alexandr middle name: Vitalevich last name: Ivanov phone: +375294097575 address: Melnikaite,10 marks: [3, 5, 6, 2, 7]");
    }

    @Test
    void setFirstNameDigitException() {
        Abiturient sasha = new Abiturient(2, "Alexandr", "Vitalevich", "Ivanov", "+375294097575","Melnikaite,10", new int[]{3, 5, 6, 2, 7});
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> sasha.setFirstName("Sasha2"));
        assertEquals("Name can't contain digits", exception.getMessage());
    }

    @Test
    void setMarkIndexException() {
    Abiturient sasha = new Abiturient(2, "Alexandr", "Vitalevich", "Ivanov", "+375294097575","Melnikaite,10", new int[]{3, 5, 6, 2, 7});
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> sasha.setMark(-1, 9));
    log.error("Index error",exception);
    assertEquals("Index should be in range of number of marks",exception.getMessage());
}
}