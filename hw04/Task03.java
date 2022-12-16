// *В калькулятор добавьте возможность отменить последнюю операцию.
package hw04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;

public class Task03 {
    public static LinkedList<Double> results = new LinkedList<>();
    
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        results.push(getNumber(iScanner));
        while (true) {
            String op = getOperation(iScanner);
            switch (op) {
                case "exit":
                    return;
                case "revert":
                    revertOperation(iScanner);                  
                    continue;
                default:
                    double nextNumber = getNumber(iScanner);
                    double result = Calc(results.peekFirst(), nextNumber, op);
                    results.push(result);
                    System.out.printf("Результат = %s\n", results.peekFirst());
                    Logger("calc.log", String.format("%s %s %s = %s", results.peekFirst(), op, nextNumber, result));
            }
        }
    }

    /**
    * Returns current DateTime in String format
    *
    * @return           the DateTime String
    */
    public static String currentDateTimeToString() {
        LocalDateTime date = LocalDateTime .now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(formatter);
    }

    /**
    * Writes message to log file
    *
    * @param  fileName  the path to log file
    * @param  msg       the message that should be logged
    */
    public static void Logger(String fileName, String msg) {
        try {
            FileWriter fw = new FileWriter(fileName, StandardCharsets.UTF_8, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.format("%s: %s", currentDateTimeToString(), msg));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.printf("cannot log information because of: %s\n", e);
        }
        
    }
    
    /**
    * Returns result of calculation for 'a' and 'b'
    *
    * @param  a     the first operand (float)
    * @param  b     the second operand (float)
    * @param  op    the operation (String)
    * @return       the calculation result (float)
    */
    public static double Calc(double a, double b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a / b;
            default:
                return a * b;
        }
    }

    /**
    * Returns double value from user input
    *
    * @param  iScanner  Scanner object used for reading
    * @return           double value from user input
    */
    public static double getNumber(Scanner iScanner) {
        System.out.print("Введите число: ");
        while (!iScanner.hasNextDouble()) {
            iScanner.next();
            System.out.printf("Вы должны ввести число! Попробуйте ещё раз: ");
        }
        return iScanner.nextDouble();
    }

    /**
    * Validates an operation
    *
    * @param  op    the operation for validation
    * @return       the result of checking
    */
    public static boolean isOperationValid(String op) {        
        String[] operations = {"+", "-", "*", "/", "revert", "exit"};
        for (String elem : operations) {
            if (elem.equals(op))
            return true;
        }        
        return false;
    }

    /**
    * Returns operation from user input
    *
    * @param  iScanner  Scanner object used for reading
    * @return           operation from user input
    */
    public static String getOperation(Scanner iScanner) {
        System.out.print("Введите операцию (+, -, *, /), 'revert' или 'exit': ");        
        String op = iScanner.next();
        while (!isOperationValid(op)) {
            System.out.printf("Вы должны ввести операцию (+, -, *, /), 'revert' или 'exit', попробуйте ещё раз: ");
            op = iScanner.next();
        }
        return op;
    }

    /**
    * Reverts last operation 
    *
    * @param  iScanner  Scanner object used for reading
    * @return           operation from user input
    */
    public static void revertOperation(Scanner iScanner) {
        results.pollFirst();
        if (results.isEmpty()) {
            results.push(getNumber(iScanner));
        } else {                        
            System.out.printf("Результат = %s\n", results.peekFirst());
        }  
    }

    /**
    * Checks if 'exit' command is retrieved
    *
    * @param  op    the operation from user inpub
    * @return       the result of checking
    */
    public static boolean isExit(String op) {
        return op.equals("exit");
    }

    /**
    * Checks if 'revert' command is retrieved
    *
    * @param  op    the operation from user inpub
    * @return       the result of checking
    */
    public static boolean isRevert(String op) {
        return op.equals("revert");
    }
}