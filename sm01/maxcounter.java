package sm01;

public class maxcounter {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 0, 1, 1, 1};
        int counter = 0;        
        int localCounter = 0;
        for (int elem : arr) {
            if (elem == 1) {
                localCounter++;
            } else {
                counter = (counter < localCounter) ? localCounter : counter;
                localCounter = 0;
            }
        }
        counter = (counter < localCounter) ? localCounter : counter;
        System.out.println(counter);
    }
}
