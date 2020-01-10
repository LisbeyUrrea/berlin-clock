import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;


    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void methodSumShouldReturn3WhenParamsAre2And1() {
        //1. Preparar parametros
        int firstNumber = 2;
        int secondNumber = 1;
        int expected = 3;

        //2. Ejecución de método a probar.
        int result = calculator.sum(firstNumber, secondNumber);

        //3. probar que lo que recibimos en la ejecución nos da lo que esperábamos
        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodSumShouldReturn10WhenParamsAre7And3() {
        //1. Preparar parametros
        int firstNumber = 7;
        int secondNumber = 3;
        int expected = 10;

        //2. Ejecución de método a probar.
        int result = calculator.sum(firstNumber, secondNumber);

        //3. probar que lo que recibimos en la ejecución nos da lo que esperábamos
        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodSubtractionShouldReturn3WhenParamsAre10And7() {

        int firstNumber = 10;
        int secondNumber = 7;
        int expected = 3;

        int result = calculator.subtraction(firstNumber, secondNumber);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodSubtractionShouldReturn5WhenParamsAre15And10() {

        int firstNumber = 15;
        int secondNumber = 10;
        int expected = 5;

        int result = calculator.subtraction(firstNumber, secondNumber);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void methodMultiplicationShouldReturn5WhenParamsAre5And5() {
        int multiplying = 5;
        int multiplier = 5;
        int expected = 25;

        int result = calculator.multiplication(multiplier, multiplier);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void methodMultiplicationShouldReturn0WhenParamsAre5And0() {
        int multiplying = 5;
        int multiplier = 0;
        int expected = 0;

        int result = calculator.multiplication(multiplying, multiplier);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void methodDivisionSouldReturn3WhenParamsAre6And2() {
        int dividend = 6;
        int divider = 2;
        double expected = 3.0;

        double result = calculator.division(dividend, divider);

        Assert.assertEquals(expected, result, 0.001);
    }

    @Test
    public void methodDivisionSouldReturnTheDecimal2Point333WhenParamsAre7And3() {
        int dividend = 7;
        int divider = 3;
        double expected = 2.3333333333333335;

        double result = calculator.division(dividend, divider);

        Assert.assertEquals(expected, result, 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void methodDivisionShouldReturnArithmeticExceptionWhenParamsAre7And0() {
        int dividend = 7;
        int divider = 0;
        double result = calculator.division(dividend, divider);
    }

    @Test(expected = ArithmeticException.class)
    public void methodDivisionShouldReturnArithmeticExceptionWhenParamsAre0And0() {
        int dividend = 0;
        int divider = 0;
        calculator.division(dividend, divider);

    }


}