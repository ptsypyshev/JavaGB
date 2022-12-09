package sm_02;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите N: ");
        int n = iScanner.nextInt();
        System.out.printf("Введите символ 1: ");
        String c1 = iScanner.next();
        System.out.printf("Введите символ 2: ");
        String c2 = iScanner.next();
        StringBuilder stringBuilder = new StringBuilder("");
        // String result = "";
        for (int i = 0; i < (n / 2); i++) {
            stringBuilder.append(c1).append(c2);
            // result += c1 + c2;
        }
        if (n % 2 != 0) {
            stringBuilder.append(c1);
            // result += c1;
        }
        System.out.println(stringBuilder.toString());
        iScanner.close();
    }
}
