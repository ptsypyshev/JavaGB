package sm01;
import java.time.LocalTime;
import java.util.Scanner;

public class getname {
    public static void main(String[] args) throws Exception{
        String encoding = System.getProperty("console.encoding", "Windows-1251");
        Scanner iScanner = new Scanner(System.in, encoding);
        System.out.printf("Имя: ");
        String name = iScanner.nextLine();

        int getTime = LocalTime.now().getHour();
        // int getTime = 20;
        String msg = "";
        switch (getTime) {
            case 5, 6, 7, 8, 9, 10, 11 -> msg = "Доброе утро";            
            case 12, 13, 14, 15, 16, 17 -> msg = "Добрый день";
            case 18, 19, 20, 21, 22 -> msg = "Добрый вечер";
            default -> msg = "Доброй ночи";
        }
        System.out.printf("%s, %s!", msg, name);
        iScanner.close();
    }
}
