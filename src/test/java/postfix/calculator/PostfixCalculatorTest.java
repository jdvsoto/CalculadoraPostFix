package postfix.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostfixCalculatorTest {

    private IPostfixCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new PostfixCalculator();
    }

    @Test
    void testSimpleAddition() throws CalculatorException {
        assertEquals(3, calculator.evaluate("1 2 +"));
    }

    @Test
    void testSimpleSubtraction() throws CalculatorException {
        assertEquals(1, calculator.evaluate("3 2 -"));
    }

    @Test
    void testSimpleMultiplication() throws CalculatorException {
        assertEquals(6, calculator.evaluate("2 3 *"));
    }

    @Test
    void testSimpleDivision() throws CalculatorException {
        assertEquals(5, calculator.evaluate("10 2 /"));
    }

    @Test
    void testSimpleModulo() throws CalculatorException {
        assertEquals(1, calculator.evaluate("10 3 %"));
    }

    @Test
    void testComplexExpression() throws CalculatorException {
        // ((1 + 2) * 4) + 3 = 15
        assertEquals(15, calculator.evaluate("1 2 + 4 * 3 +"));
    }

    @Test
    void testAnotherComplexExpression() throws CalculatorException {
        // 6 * (2 + 3) = 30
        assertEquals(30, calculator.evaluate("6 2 3 + *"));
    }

    @Test
    void testMultiDigitOperands() throws CalculatorException {
        assertEquals(30, calculator.evaluate("10 20 +"));
    }

    @Test
    void testDivisionByZeroThrows() {
        assertThrows(CalculatorException.class, () -> calculator.evaluate("5 0 /"));
    }

    @Test
    void testModuloByZeroThrows() {
        assertThrows(CalculatorException.class, () -> calculator.evaluate("5 0 %"));
    }

    @Test
    void testInvalidTokenThrows() {
        assertThrows(CalculatorException.class, () -> calculator.evaluate("1 abc +"));
    }

    @Test
    void testInsufficientOperandsThrows() {
        assertThrows(CalculatorException.class, () -> calculator.evaluate("1 +"));
    }

    @Test
    void testTooManyOperandsThrows() {
        assertThrows(CalculatorException.class, () -> calculator.evaluate("1 2 3 +"));
    }

    @Test
    void testSubtractionOrder() throws CalculatorException {
        // 5 - 3 = 2 (not 3 - 5)
        assertEquals(2, calculator.evaluate("5 3 -"));
    }

    @Test
    void testDivisionOrder() throws CalculatorException {
        // 10 / 2 = 5 (not 2 / 10)
        assertEquals(5, calculator.evaluate("10 2 /"));
    }
}
