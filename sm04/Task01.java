// Реализовать консольное приложение, которое:
// Принимает от пользователя строку вида 
// text~num
// Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
// Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.

package sm04;

import java.util.LinkedList;
import java.util.Scanner;

public class Task01 {
    public static LinkedList<String> result = new LinkedList<>();

    public static void AddNum(int num, String cmd) {
        try {
            result.add(num, cmd);
        } catch (Exception e) {
            System.out.println(e);
            while (result.size() < num) {
                result.add(null);
            }
            result.add(cmd);
        }
    }

    public static void PrintNum(int num) {
        if (result.size() < num ) {
            System.out.printf("В списке меньше элементов, чем %d\n", num);
        } else {
            String tmp = result.get(num);
            result.remove(num);
            System.out.println(tmp);
        } 
    }

    public static boolean isExit(String cmd) {
        return cmd.equals("exit");
    }

    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);        
        while (true) {
            System.out.printf("Введите строку или 'exit' для выхода: ");
            String line = sc.nextLine();
            if (isExit(line)) {
                break;
            }

            String[] lineSplitted = line.split("~");
            String cmd = lineSplitted[0];
            try {
                int num = Integer.parseInt(lineSplitted[1]);                
                if (cmd.equals("print")) {
                    PrintNum(num);                
                } else {
                    AddNum(num, cmd);
                }
            } catch (ArrayIndexOutOfBoundsException e) {                
                AddNum(result.size(), line);                
            }
            
            System.out.println(result);
       }
       sc.close();       
    }
}
