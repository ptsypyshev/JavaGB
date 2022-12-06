package hw01;

import java.util.Scanner;

public class Task03 {
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
        if(result == (int) result)
            System.out.printf("Результат = %d",(int)result);
        else
            System.out.printf("Результат = %s",result);
        iScanner.close();
    }
}
