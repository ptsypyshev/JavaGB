package sm01;

public class shiftelem {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 2, 3, 5, 4, 6, 3, 1};
        int val = 3;

        int[] result = new int[nums.length];
        int counter = 0;
        int iter = 0;

        for (int elem : nums) {
            if (elem == val) {
                counter++;
            } else {
                result[iter] = elem;
                iter++;
            }            
        }

        for (int i = iter; i < iter + counter; i++) {
            result[i] = val;
        }

        for (int i : result) {
            System.out.println(i);
        }
        
    }
}
