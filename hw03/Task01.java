// Реализовать алгоритм сортировки слиянием
package hw03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task01 {
    /**
    * Returns sorted List using Merge Sort algorithm. 
    *
    * @param  arr  unsorted List<Integer>
    * @return      sorted List<Integer>
    */
    public static List<Integer> mergeSort(List<Integer> arr) {
        if (arr.size() == 1) {
            return arr;
        }
        int middle = arr.size() / 2;
        List<Integer> left = arr.subList(0, middle);
        List<Integer> right = arr.subList(middle, arr.size());
        if (left.size() > 1) left = mergeSort(left);
        if (right.size() > 1) right = mergeSort(right);
        List<Integer> sortedArr = new ArrayList<Integer>();
        int left_idx = 0;
        int right_idx = 0;
        while (left_idx < left.size() | right_idx < right.size()) {
            // System.out.printf("Left arr: %s, Right arr: %s\n", left, right);
            if (left_idx == left.size() && right_idx == right.size()) break;
            if (left_idx == left.size()) {
                sortedArr.add(right.get(right_idx));
                right_idx++;
            }
            else if (right_idx == right.size()) {
                sortedArr.add(left.get(left_idx));
                left_idx++;
            }
            else if (left.get(left_idx) < right.get(right_idx)) {
                sortedArr.add(left.get(left_idx));
                left_idx++;
            } else {
                sortedArr.add(right.get(right_idx));
                right_idx++;
            }
            // System.out.printf("Sorted arr: %s, left_idx=%d, right_idx=%d\n", sortedArr, left_idx, right_idx);
            
        }
        return sortedArr;
    }

    public static void main(String[] args) {
        List<Integer> origArr = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 8, 2, 5, 9, 7, 6));
        System.out.printf("Original array is:\t%s\n", origArr);
        List<Integer> sortedArr = mergeSort(origArr);
        System.out.printf("Sorted array is:\t%s\n", sortedArr);
    }
}
