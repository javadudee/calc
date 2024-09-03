public class Calculator {

    // final result calculated by chain operation
    private Number result;

    public Calculator() {
    }
    public Calculator(Number initialValue) {
        this.result = initialValue;
    }

    /** Method to perform the operation based on the Operation type
     *
     * @param num1 Number could be floating point or integer
     * @param num2 Number could be floating point or integer
     * @param operation enum to do operations like add, subtract etc.
     * @return result of the operation
     */
    public Number calculate(Number num1, Number num2, Operation operation) {
        return operation.calculate(num1, num2);
    }

    /** Method to chain calculate method of Operation
     *
     * @param number Initial
     * @param operation enum to do operations like add, subtract etc.
     * @return result of applying the operation
     */
    public Calculator applyOperation(Number number, Operation operation) {
        this.result = operation.calculate(this.result, number);
        return this;
    }

    public Number getResult() {
        return result;
    }
}
