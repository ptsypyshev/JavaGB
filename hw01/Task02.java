package hw01;

public class Task02 {
    /**
    * Returns the sieve of Eratosthenes for Prime numbers. 
    *
    * @param  num  a length of the sieve
    * @return      the boolean array which has false values for Prime numbers and true values for Composite numbers
    */
    public static boolean[] makeSieve(int num) {
        boolean[] sieve = new boolean[num + 1];
        sieve[0] = true;
        sieve[1] = true;
        for (int i = 2; i * i <= num; i++) {
            if (!sieve[i]) {
                for (int j = i * i; j <= num; j+=i) {
                    sieve[j] = true;
                }
            }
        }
        return sieve;
    }

    /**
    * Returns number of false values in array. 
    *
    * @param  arr  an boolean array to count false values
    * @return      the number of false values in array
    */
    public static int falseCounter(boolean[] arr) {
        int counter = 0;
        for (boolean elem : arr) {
            if (!elem) counter++;
        }
        return counter;
    }

    /**
    * Returns the array of Prime numbers up to 'num' value. 
    *
    * @param  num  the upper limit for searching Prime numbers
    * @return      the int array of Prime numbers
    */
    public static int[] PrimeNumbers(int num) {
        boolean[] sieve = makeSieve(num);        
        int[] result = new int[falseCounter(sieve)];
        int iter = 0;

        for (int i = 2; i <= num; i++) {
            if (!sieve[i]){
                result[iter] = i;
                iter++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int i = 1000;
        for (int elem : PrimeNumbers(i)) {
            System.out.println(elem);    
        }        
    }
}
