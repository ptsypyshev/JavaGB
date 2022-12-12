package hw02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Task02 {
    /**
    * Returns current DateTime in String format
    *
    * @return           the DateTime String
    */
    public static String currentDateTimeToString() {
        LocalDateTime date = LocalDateTime .now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(formatter);
    }

    /**
    * Writes message to log file. 
    *
    * @param  fileName  the path to log file
    * @param  msg       the message that should be logged
    */
    public static void Logger(String fileName, String msg) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.format("%s: %s", currentDateTimeToString(), msg));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.printf("cannot log information because of: %s\n", e);
        }
        
    }

    /**
    * Swaps values of two array members. 
    *
    * @param  arr   the array of ints
    * @param  i     the first index of array
    * @param  j     the second index of array
    */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j]; 
        arr[j] = tmp;
    }

    /**
    * Sorts array of ints with Bubble Sort algorithm. 
    *
    * @param  arr   the array of ints
    */
    public static void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);                    
                    Logger("sort.log", Arrays.toString(arr));
                }
            }            
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 14, 28, 11, 7, 16, 30, 50, 25, 18};
        BubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
