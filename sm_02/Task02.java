package sm_02;

import java.util.Scanner;

public class Task02 {
    public static void formatter(int counter, char ch) {
        if (counter != 1) {
            System.out.printf("%s%d", ch, counter);
        } else {
            System.out.printf("%s", ch);
        } 
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String orig = iScanner.next();
        System.out.print("Результат: ");
        // String orig = "aaaabbbcddeeaavqq";
        int counter = 1;
        for (int i = 0; i < orig.length() - 1; i++) {
            if (orig.charAt(i) == orig.charAt(i + 1)) {
                counter++;
            } else {
                formatter(counter, orig.charAt(i));
                counter = 1;
            }
        }
        formatter(counter, orig.charAt(orig.length() - 1));
        iScanner.close();
    }
}
