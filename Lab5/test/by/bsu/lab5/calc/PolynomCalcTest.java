package by.bsu.lab5.calc;

import by.bsu.lab5.entity.Polynom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomCalcTest {

    @Test
    void add() {
        Polynom a=new Polynom(3,new double[]{1,2,3});
        Polynom b=new Polynom(2,new double[]{1,2});
        PolynomCalc solver=new PolynomCalc();
        Polynom result=solver.add(a,b);
        Polynom expected=new Polynom(3,new double[]{2,4,3});
        assertEquals(result,expected);
    }
    @Test
    void subtract()
    {
        Polynom a=new Polynom(3,new double[]{1,2,3});
        Polynom b=new Polynom(2,new double[]{1,2});
        PolynomCalc solver=new PolynomCalc();
        Polynom result=solver.subtract(a,b);
        Polynom expected=new Polynom(3,new double[]{0,0,3});
        assertEquals(result,expected);
    }
    @Test
    void multiply()
    {
        Polynom a=new Polynom(1,new double[]{1,1});
        Polynom b=new Polynom(0,new double[]{2});
        PolynomCalc solver=new PolynomCalc();
        Polynom result=solver.multiply(a,b);
        Polynom expected=new Polynom(1,new double[]{2,2});
        assertEquals(result,expected);
    }
}