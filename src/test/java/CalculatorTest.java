import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAdditionWithIntegers() {
        Number result = calculator.calculate(10, 5, Operation.ADD);
        assertEquals(15.0, result.doubleValue());
    }

    @Test
    public void testAdditionWithDoubles() {
        Number result = calculator.calculate(10.5, 5.5, Operation.ADD);
        assertEquals(16.0, result.doubleValue());
    }

    @Test
    public void testSubtractionWithIntegers() {
        Number result = calculator.calculate(10, 5, Operation.SUBTRACT);
        assertEquals(5.0, result.doubleValue());
    }

    @Test
    public void testSubtractionWithDoubles() {
        Number result = calculator.calculate(10.5, 5.5, Operation.SUBTRACT);
        assertEquals(5.0, result.doubleValue());
    }

    @Test
    public void testMultiplicationWithIntegers() {
        Number result = calculator.calculate(10, 5, Operation.MULTIPLY);
        assertEquals(50.0, result.doubleValue());
    }

    @Test
    public void testMultiplicationWithDoubles() {
        Number result = calculator.calculate(10.5, 5.5, Operation.MULTIPLY);
        assertEquals(57.75, result.doubleValue());
    }

    @Test
    public void testDivisionWithIntegers() {
        Number result = calculator.calculate(10, 5, Operation.DIVIDE);
        assertEquals(2.0, result.doubleValue());
    }

    @Test
    public void testDivisionWithDoubles() {
        Number result = calculator.calculate(10.5, 5.5, Operation.DIVIDE);
        assertEquals(1.9090909090909092, result.doubleValue());
    }

    @Test
    public void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () ->
                calculator.calculate(10, 0, Operation.DIVIDE));
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @Test
    public void testAdditionWithLargeNumbers() {
        Number result = calculator.calculate(1_000_000, 2_000_000, Operation.ADD);
        assertEquals(3_000_000.0, result.doubleValue());
    }

    @Test
    public void testSubtractionResultingInNegativeNumber() {
        Number result = calculator.calculate(5, 10, Operation.SUBTRACT);
        assertEquals(-5.0, result.doubleValue());
    }

    @Test
    public void testMultiplicationWithZero() {
        Number result = calculator.calculate(10, 0, Operation.MULTIPLY);
        assertEquals(0.0, result.doubleValue());
    }

    @Test
    public void testDivisionWithOne() {
        Number result = calculator.calculate(10, 1, Operation.DIVIDE);
        assertEquals(10.0, result.doubleValue());
    }

    @Test
    public void testOperationsWithNegativeNumbers() {
        Number resultAdd = calculator.calculate(-10, -5, Operation.ADD);
        assertEquals(-15.0, resultAdd.doubleValue());

        Number resultSubtract = calculator.calculate(-10, -5, Operation.SUBTRACT);
        assertEquals(-5.0, resultSubtract.doubleValue());

        Number resultMultiply = calculator.calculate(-10, -5, Operation.MULTIPLY);
        assertEquals(50.0, resultMultiply.doubleValue());

        Number resultDivide = calculator.calculate(-10, -5, Operation.DIVIDE);
        assertEquals(2.0, resultDivide.doubleValue());
    }
}
