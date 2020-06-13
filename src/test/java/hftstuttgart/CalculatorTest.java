package hftstuttgart;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
    @Test
    public void sumNumbers() {
        Calculator calc = new Calculator();
        int sum = calc.sum(31, 11);
        assertEquals(42, sum);
    }

    @Test
    public void prodNumbers() {
        Calculator calc = new Calculator();
        int prod = calc.prod(3, 7);
        assertEquals(21, prod);
    }
}