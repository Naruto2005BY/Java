package culc.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void sum() {
        int a = 1;
        int b = 3;
        int expected = 4;
        Calculator calc = new Calculator();
        int actual = calc.sum(a,b);
        assertEquals(expected,actual);
    }

    @Test
    void mult() {
        int a = 0;
        int b = 3;
        int expected = 0;
        Calculator calc = new Calculator();
        int actual = calc.mult(a,b);
        assertEquals(expected,actual);

    }
}