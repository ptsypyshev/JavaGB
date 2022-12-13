// Пусть дан произвольный список целых чисел, удалить из него четные числа
package hw03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task02 {
    /**
    * Removes even numbers from List
    *
    * @param  arr  original List<Integer>
    */
    public static void removeEvenNumbers(List<Integer> arr) {
        int idx = 0;
        while (idx < arr.size()) {
            if (arr.get(idx) % 2 == 0) {
                arr.remove(idx);
            } else {
                idx++;
            }
        }
    }
    
    public static void main(String[] args) {
        List<Integer> Arr = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 8, 2, 5, 9, 7, 6));
        System.out.printf("Original array is:\t%s\n", Arr);
        removeEvenNumbers(Arr);
        System.out.printf("Modified array is:\t%s\n", Arr);
    }
}
