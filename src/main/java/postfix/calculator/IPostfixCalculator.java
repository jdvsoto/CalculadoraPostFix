package postfix.calculator;

public interface IPostfixCalculator {

    /**
     * Evaluates a postfix expression and returns the result.
     *
     * @param expression the postfix expression to evaluate
     * @return the result of evaluating the expression
     * @throws CalculatorException if the expression is invalid
     */
    int evaluate(String expression) throws CalculatorException;
}
