// 1. Напишите метод, который заполнит массив из 1000 элементов случайными цифрами от 0 до 24. 
// 2. Создайте метод, в который передайте заполненный выше массив и с помощью Set вычислите процент уникальных значений в данном массиве и верните его в виде числа с плавающей запятой.
// Для вычисления процента используйте формулу:
// процент уникальных чисел = количество уникальных чисел * 100 / общее количество чисел в массиве.

package sm06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Task01 {
    public static void main(String[] args) {
        ArrayList<Integer> user_list = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            user_list.add(new Random().nextInt(25));
        }
        System.out.printf("Процент уникальных значений: %s%s", uniqueNum(user_list), "%");
    }

    public static double uniqueNum(ArrayList<Integer> list) {
        HashSet<Integer> new_set = new HashSet<>(list);
        return ((double) new_set.size() / (double) list.size()) * 100;
    }

}
