package postfix.calculator;

import postfix.stack.IStack;
import postfix.stack.VectorStack;

public class PostfixCalculator implements IPostfixCalculator {

    private IStack<Integer> stack;

    public PostfixCalculator() {
        stack = new VectorStack<>();
    }

    @Override
    public int evaluate(String expression) throws CalculatorException {
        stack.clear();
        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new CalculatorException("Insufficient operands for operator: " + token);
                }
                int operandB = stack.pop();
                int operandA = stack.pop();
                int result = applyOperator(operandA, operandB, token);
                stack.push(result);
            } else {
                try {
                    int operand = Integer.parseInt(token);
                    stack.push(operand);
                } catch (NumberFormatException e) {
                    throw new CalculatorException("Invalid token: " + token);
                }
            }
        }

        if (stack.size() != 1) {
            throw new CalculatorException("Invalid expression: too many operands");
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*")
                || token.equals("/") || token.equals("%");
    }

    private int applyOperator(int a, int b, String operator) throws CalculatorException {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) {
                    throw new CalculatorException("Division by zero");
                }
                return a / b;
            case "%":
                if (b == 0) {
                    throw new CalculatorException("Division by zero");
                }
                return a % b;
            default:
                throw new CalculatorException("Unknown operator: " + operator);
        }
    }
}
