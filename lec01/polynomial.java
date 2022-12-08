/**
 * 01_polynomial
 */
import java.util.concurrent.ThreadLocalRandom;
public class polynomial {
    public static void main(String[] args) {
        int k = 5;
        int[] arr = new int[k];
        String res = "";

        for (int i = 0; i < k; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(0, 100 + 1);
        }
        
        for (int i : arr) {
            if (res.length() > 0) res += " + ";
            res += String.format("%dx^%d", i, k--);
        }
        System.out.println(res);
    }
}