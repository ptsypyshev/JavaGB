package hw02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Task04 {
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
    * Writes message to log file. 
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
    * Returns result of calculation for 'a' and 'b'. 
    *
    * @param  a     the first operand (float)
    * @param  b     the second operand (float)
    * @param  op    the operation (String)
    * @return       the calculation result (float)
    */
    public static float Calc(float a, float b, String op) {
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

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите первый операнд: ");
        float a = iScanner.nextInt();
        System.out.print("Введите операцию (+, -, * или /): ");
        String op = iScanner.next();
        System.out.print("Введите второй операнд: ");
        float b = iScanner.nextInt();
        float result = Calc(a, b, op);
        String resultString;
        if(result == (int) result)
            resultString = String.format("Результат = %d",(int)result);            
        else
            resultString = String.format("Результат = %s",result);
        System.out.println(resultString);
        Logger("calc.log", String.format("%s %s %s = %s", a, op, b, result));
        iScanner.close();
    }
}
