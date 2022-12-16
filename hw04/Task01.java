// Пусть дан LinkedList с несколькими элементами.
// Реализуйте метод, который вернет “перевернутый” список.
package hw04;

import java.util.Arrays;
import java.util.LinkedList;

public class Task01 {
    public static void main(String[] args) {
        LinkedList<Object> orig = new LinkedList<Object>(Arrays.asList(null, 1, '2', true, 4, "five", false));
        System.out.printf("Original list is: %s\n", orig);
        System.out.printf("Reversed list is: %s\n", Reverse(orig));
    }
    
    /**
    * Returns reversed LinkedList. 
    *
    * @param  lst  unsorted LinkedList
    * @return      reversed LinkedList
    */
    public static LinkedList<Object> Reverse(LinkedList<Object> lst) {
        LinkedList<Object> result = new LinkedList<Object>();
        for (Object elemObject : lst) {
            result.addFirst(elemObject);
        }
        return result;
    }
}
