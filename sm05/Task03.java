// Написать метод, который переведёт данное целое число в римский формат.

package sm05;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task03 {
    public static final Map<Integer, String> ArabToRoman = new LinkedHashMap<>(){{
        put(1000, "M");        
        put(900, "CM");        
        put(500, "D");        
        put(400, "CD");
        put(100, "C");        
        put(90, "XC");        
        put(50, "L");
        put(40, "XL");        
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");  
    }};

    public static String ArabToRoman(int number) {
        String result = "";
        for (Map.Entry<Integer, String> elemEntry : ArabToRoman.entrySet()) {
            if (number >= elemEntry.getKey()) {
                int tmp = number / elemEntry.getKey();
                result += elemEntry.getValue().repeat(tmp);
                number -= tmp * elemEntry.getKey();
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(ArabToRoman(2022));
        System.out.println(ArabToRoman(44));
        System.out.println(ArabToRoman(96));
        System.out.println(ArabToRoman(4597));
    }
}
