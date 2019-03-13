package by.bsu.lab3.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ServicesTest {
    static Services service;


    @BeforeAll
    static void setUp()
    {
        service=new Services();
    }


    @Test
    void getCountsOfDigitsDouble() {
        double number = 12321.031;
        int expected = 8;
        int actual = service.getCountsOfDigits(number);
        assertEquals(expected,actual);
    }

    @Test
    void getCharsOfIntegerEndingOnZero() {
        double number = 85580;
        int[] expected = {8, 5, 5, 8,0};
        int[] actual = service.getCharsOfNumber(number);
        assertTrue(Arrays.equals(expected, actual));
    }
    @Test
    void getCountsOfDigitsInteger() {
        double number = 101010;
        int expected = 6;
        int actual = service.getCountsOfDigits(number);
        assertEquals(expected, actual);
    }

    @Test
    void getCharsOfIntegerDecimal() {
        double number = 94532.001;
        int[] expected = {9, 4, 5, 3, 2,0,0,1};
        int[] actual = service.getCharsOfNumber(number);
        assertTrue(Arrays.equals(expected, actual));
    }

    @Test
    void getCountsOfDigitsZero() {
        double number = 0;
        int expected = 1;
        int actual = service.getCountsOfDigits(number);
        assertEquals(expected, actual);
    }

    @Test
    void getCharsOfIntegerNegativeDecimal() {
        double number = -85580.012;
        int[] expected = {8, 5, 5, 8,0,0,1,2};
        int[] actual = service.getCharsOfNumber(number);
        assertTrue(Arrays.equals(expected, actual));
    }
}