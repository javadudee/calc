import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorChainingTest {

    @Test
    public void testChainedAdditionAndMultiplication() {
        Calculator calculator = new Calculator(10);
        Number result = calculator
                .applyOperation(5, Operation.ADD)
                .applyOperation(2, Operation.MULTIPLY)
                .getResult();
        assertEquals(30.0, result.doubleValue());
    }

    @Test
    public void testChainedSubtractionAndDivision() {
        Calculator calculator = new Calculator(20);
        Number result = calculator
                .applyOperation(5, Operation.SUBTRACT)
                .applyOperation(3, Operation.DIVIDE)
                .getResult();
        assertEquals(5.0, result.doubleValue());
    }

    @Test
    public void testChainedAdditionWithNegativeNumber() {
        Calculator calculator = new Calculator(10);
        Number result = calculator
                .applyOperation(-5, Operation.ADD)
                .applyOperation(3, Operation.MULTIPLY)
                .getResult();
        assertEquals(15.0, result.doubleValue());
    }

    @Test
    public void testChainedDivisionByOne() {
        Calculator calculator = new Calculator(100);
        Number result = calculator
                .applyOperation(10, Operation.DIVIDE)
                .applyOperation(10, Operation.DIVIDE)
                .getResult();
        assertEquals(1.0, result.doubleValue());
    }

    @Test
    public void testChainedMultiplicationWithZero() {
        Calculator calculator = new Calculator(100);
        Number result = calculator
                .applyOperation(0, Operation.MULTIPLY)
                .applyOperation(10, Operation.ADD)  // Should have no effect since previous result is zero
                .getResult();
        assertEquals(10.0, result.doubleValue());
    }

    @Test
    public void testChainedDivisionByZero() {
        Calculator calculator = new Calculator(10);
        Exception exception = assertThrows(ArithmeticException.class, () ->
                calculator
                        .applyOperation(0, Operation.DIVIDE)
                        .getResult());
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @Test
    public void testChainedOperationsWithDoubleValues() {
        Calculator calculator = new Calculator(10.5);
        Number result = calculator
                .applyOperation(5.5, Operation.ADD)
                .applyOperation(2.0, Operation.MULTIPLY)
                .applyOperation(3.0, Operation.DIVIDE)
                .getResult();
        assertEquals(10.666666666666666, result.doubleValue(), 0.0000001);
    }

    @Test
    public void testChainedOperationsStartingWithZero() {
        Calculator calculator = new Calculator(0);
        Number result = calculator
                .applyOperation(5, Operation.ADD)
                .applyOperation(10, Operation.SUBTRACT)
                .applyOperation(2, Operation.MULTIPLY)
                .getResult();
        assertEquals(-10.0, result.doubleValue());
    }
}
