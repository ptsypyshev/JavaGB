package sm03;

import java.util.ArrayList;

public class Task01 {

    public static void main(String[] args) {
        ArrayList<Integer> origList = new ArrayList<Integer>(10);
        for (int i = 0; i < 10; i++) {
            origList.add((int) (Math.random()*100));
        }

        origList.sort(null);

        for (Integer elemDouble : origList) {
            System.out.println(elemDouble);
        }
    }
}
