// Создать список типа ArrayList<String>. 
// Поместить в него как строки, так и целые числа.
// Пройти по списку, найти и удалить целые числа.
package sm03;

import java.util.ArrayList;
import java.util.Arrays;

public class Task03 {
    public static boolean isInteger(String elem) {
        try {
            Integer.parseInt(elem);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> arrList = new ArrayList<String>(Arrays.asList("Меркурий", "1", "3", "Венера", "2", "Земля"));
        for (int i = 0; i < arrList.size(); i++) {
            if (isInteger(arrList.get(i))) {
                arrList.remove(arrList.get(i));
                i--;
            }
        }

        System.out.println(arrList);
    }
}
