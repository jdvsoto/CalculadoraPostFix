package postfix.calculator;

public interface IPostfixCalculator {

    /**
     * Evalúa una expresión aritmética escrita en notación postfix.
     *
     * <p>La expresión debe estar compuesta por operandos enteros positivos y
     * operadores aritméticos básicos (+, -, *, /, %), separados por espacios.
     * pila para llevar a cabo la evaluación y de lanzar una excepción


     
     * {@link CalculatorException} en caso de errores como división entre cero,
     * operandos insuficientes o símbolos inválidos.</p>
     *
     * @param expression la expresión en notación postfix que se desea evaluar
     * @return el resultado entero de la evaluación
     * @throws CalculatorException si la expresión contiene errores de formato o aritméticos
     */
    int evaluate(String expression) throws CalculatorException;
}
