// Задан целочисленный список ArrayList.
// Найти минимальное, максимальное и среднее из этого списка.
package hw03;

import java.util.ArrayList;
import java.util.Arrays;

public class Task03 {
    /**
    * Returns minimal element of List
    *
    * @param  arr  original List
    * @return      minimal element of List
    */
    public static int Min(ArrayList<Integer> arr) {
        int min = arr.get(0);
        for (Integer elem : arr) {
            if (elem < min) min = elem;
        }
        return min;
    }

    /**
    * Returns maximal element of List 
    *
     * @param  arr  original List
    * @return      maximal element of List
    */
    public static int Max(ArrayList<Integer> arr) {
        int max = arr.get(0);
        for (Integer elem : arr) {
            if (elem > max) max = elem;
        }
        return max;
    }

    /**
    * Returns mean element of List (or closest to the mean if mean value is not integer). 
    *
    * @param  arr  original List
    * @return      mean element of List
    */
    public static int Mean(ArrayList<Integer> arr) {
        int sum = 0;
        for (Integer elem : arr) {
            sum += elem;
        }
        double realMean = (double) sum / (double) arr.size();
        double mean_diff = Math.abs((double) arr.get(0) - realMean);
        int mean = arr.get(0);
        for (Integer elem : arr) {
            double tmp_mean_diff = Math.abs((double) elem - realMean);
            if (tmp_mean_diff < mean_diff) {
                mean = elem;
                mean_diff = tmp_mean_diff;
            }
        }
        return mean;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 8, 2, 5, 9, 7, 6));
        System.out.printf("Original array is: %s\n", arr);
        System.out.printf("Minimal element of array has value:\t%d\n", Min(arr));
        System.out.printf("Maximal element of array has value:\t%d\n", Max(arr));
        System.out.printf("Mean element of array has value:\t%d\n", Mean(arr));
    }
}
