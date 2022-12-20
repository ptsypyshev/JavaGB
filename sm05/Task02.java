// Написать метод, который переведет число из римского формата записи в арабский. 
// Например, MMXXII = 2022
// http://graecolatini.bsu.by/htm-different/num-converter-roman.htm

package sm05;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task02 {
    public static final Map<String, Integer> RomanToArab = new LinkedHashMap<>(){{
        put("M", 1000);
        put("CM", 900);        
        put("D", 500);
        put("CD", 400);
        put("C", 100);
        put("XC", 90);
        put("L", 50);
        put("XL", 40);
        put("X", 10);
        put("V", 5);
        put("IX", 9);
        put("IV", 4);
        put("I", 1);        
    }};

    public static int ConvertRimToArab(String romanNumber) {
        int result = 0;
        for (int i = 0; i < romanNumber.length(); i++) {            
            if (i + 1 < romanNumber.length()) {
                String subNumber = romanNumber.substring(i, i+2);
                if (RomanToArab.containsKey(subNumber)) {
                    result += RomanToArab.get(subNumber);
                    i++;
                    continue;
                }
            }
            result += RomanToArab.get(String.valueOf(romanNumber.charAt(i)));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(ConvertRimToArab("MMXXII"));
        System.out.println(ConvertRimToArab("IV"));
        System.out.println(ConvertRimToArab("MCDLXXIV"));
    }
}
