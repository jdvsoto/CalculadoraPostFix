package postfix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import postfix.calculator.CalculatorException;
import postfix.calculator.IPostfixCalculator;
import postfix.calculator.PostfixCalculator;

public class Main {

    public static void main(String[] args) {
        IPostfixCalculator calculator = new PostfixCalculator();
        String filePath = "datos.txt";

        // try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        //     String line;
        //     while ((line = reader.readLine()) != null) {
        //         if (line.trim().isEmpty()) {
        //             continue;
        //         }
        //         try {
        //             int result = calculator.evaluate(line);
        //             System.out.println("Resultado: " + result);
        //         } catch (CalculatorException e) {
        //             System.out.println("Error: " + e.getMessage());
        //         }
        //     }
        // } catch (IOException e) {
        //     System.out.println("Error reading file: " + e.getMessage());
        // }
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        Main.class.getClassLoader().getResourceAsStream("datos.txt")
                ))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    int result = calculator.evaluate(line);
                    System.out.println("Resultado: " + result);
                } catch (CalculatorException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        InputStream is = Main.class.getClassLoader().getResourceAsStream("datos.txt");
        if (is == null) {
            System.out.println("Archivo datos.txt no encontrado en resources");
            return;
        }

    }
}
