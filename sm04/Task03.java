// 1) Написать метод, который принимает массив элементов, помещает их в стэк и выводит на консоль содержимое стэка.
// 2) Написать метод, который принимает массив элементов, помещает их в очередь и выводит на консоль содержимое очереди.

package sm04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Task03 {
    public static Stack<Object> st = new Stack<>();
    public static Queue<Object> q = new LinkedList<Object>();

    public static void CustomStackAdd(Object[] arr) {        
        for (Object elem : arr) {
            st.push(elem);
        }
        
        while (!st.empty()) {
            System.out.println(st.pop());
        }
    }

    public static void CustomQueueAdd(Object[] arr) {
        for (Object elem : arr) {
            q.add(elem);
        }        
        
        while (q.size() > 0) {
            System.out.println(q.poll());
        }
    }

    public static void main(String[] args) {
        Object[] arr = {"Start", 1, 2, 3, "End"};
        CustomStackAdd(arr);
        System.out.println(" ");
        CustomQueueAdd(arr);
    }
}
