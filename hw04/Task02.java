// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди;
// dequeue() - возвращает первый элемент из очереди и удаляет его;
// first() - возвращает первый элемент из очереди, не удаляя.
package hw04;

import java.util.LinkedList;

public class Task02 {
    public static LinkedList<Object> queue = new LinkedList<Object>();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.printf("Try enqueue: %d\n", i);
            enqueue(i);
        }
        System.out.printf("Queue is: %s\n", queue);

        for (int i = 0; i < 3; i++) {
            System.out.printf("Try dequeue: %d\n", dequeue());
        }        
        System.out.printf("Queue is: %s\n", queue);

        System.out.printf("Try first: %d\n", first());
        System.out.printf("Queue is: %s\n", queue);

    }

    /**
    * Adds element to the queue. 
    *
    * @param  elem  element to adding
    */
    public static void enqueue(Object elem) {
        queue.push(elem);
    }

    /**
    * Retrieves and removes the first element from the queue. 
    *
    * @return      the first element from the queue
    */
    public static Object dequeue() {
        return queue.pollLast();
    }

    /**
    * Retrieves, but doesn't remove the first element from the queue. 
    *
    * @return      the first element from the queue
    */
    public static Object first() {
        return queue.peekLast();
    }
}
