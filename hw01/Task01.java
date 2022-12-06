package hw01;
import java.util.Scanner;

public class Task01 {
    /**
    * Returns Triangle Number's value. 
    *
    * @param  num  the Triangle number index
    * @return      the Triangle Number's value
    */
    public static int TriangleNum(int num) {
        int result = 0;
        for (int i = 1; i <= num; i++) {
            result += i;
        }
        return result;
    }

    /**
    * Returns Factorial of number. 
    *
    * @param  num  the integer number
    * @return      the factorial of 'num'
    */
    public static int Factorial(int num) {
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {        
        Scanner iScanner = new Scanner(System.in, "UTF-8");
        System.out.print("Введите число: ");
        boolean isInt = iScanner.hasNextInt();
        while (!isInt) {
            System.out.print("Это не число. Попробуйте ввести число ещё раз: ");
            iScanner.next();
            isInt = iScanner.hasNextInt();
        }
        int num = iScanner.nextInt();
        System.out.printf("Треугольное число №%s = %s\n", num, TriangleNum(num));
        System.out.printf("Факториал %s! = %s\n", num, Factorial(num));
        iScanner.close();
    }
}
