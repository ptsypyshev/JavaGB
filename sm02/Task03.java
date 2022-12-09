package sm02;

import java.util.Scanner;

public class Task03 {
    public static boolean Palindrome(String s) {
        if (s == "") return false;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String inputString = iScanner.next();
        System.out.print("Результат: ");
        System.out.println(Palindrome(inputString));
        iScanner.close();
    }
}
