package hw01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Task04 {
    /**
    * Returns array with possible numbers. 
    *
    * @param  s     the string with "?" sign
    * @return       the array with possible numbers (int[])
    */
    public static int[] getNumbers(String s) {
        int[] numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            String tmp = s.replace("?", Integer.toString(i));
            int number = Integer.parseInt(tmp);
            numbers[i] = number;
        }
        return numbers;
    }

    /**
    * Returns restored statement or failure message. 
    *
    * @param  s     the statement string with "?" signs at operands
    * @return       the restored statement or failure message (String)
    */
    public static String restoreStatement(String s) {
        String[] splittedLine = new String[3];
        int idx = 0;
        String pattern = "[\\d|\\?]{1,}";
        Pattern re = Pattern.compile(pattern);
        Matcher m = re.matcher(s);
        while (m.find()) {
            splittedLine[idx++] = m.group();
        }

        int e = Integer.parseInt(splittedLine[2]);
        for (int q : getNumbers(splittedLine[0])) {
            for (int w : getNumbers(splittedLine[1])) {
                if (q + w == e ) return String.format("%d + %d = %d", q, w, e);
            }
        }
        return "No ways to restore the statement...";
    }

    public static void main(String[] args) {
        // String line = "2? + ?5 = 69";
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите выражение (например, 2? + ?5 = 69): ");
        String line = iScanner.nextLine();
        System.out.println(restoreStatement(line));
        iScanner.close();
    }
}
