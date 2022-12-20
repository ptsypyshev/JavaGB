// Даны 2 строки, написать метод, который вернет true, если эти строки являются изоморфными и false, если нет. Строки изоморфны, если одну букву в первом слове можно заменить на некоторую букву во втором слове, при этом
// повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением порядка следования. (Например, add - egg изоморфны)
// буква может не меняться, а остаться такой же. (Например, note - code)
// Пример 1:
// Input: s = "foo", t = "bar"
// Output: false
// Пример 2:
// Input: s = "paper", t = "title"
// Output: true

package sm05;

import java.util.HashMap;
import java.util.Map;

public class Task01 {
    public static Map<Character, Integer> getCounts(String s) {
        Map<Character, Integer> sMap= new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (sMap.containsKey(tmp)) {
                sMap.put(tmp, sMap.get(s.charAt(i)) + 1);
            } else {
                sMap.put(tmp, 1);
            }            
        }
        return sMap;
    }

    public static boolean CheckIsomorph(String s1, String s2) {
        Map<Character, Integer> s1Map = getCounts(s1);
        Map<Character, Integer> s2Map = getCounts(s2);
        System.out.printf("%s %s = ", s1, s2);
        if (s1Map.size() != s2Map.size()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1Map.get(s1.charAt(i)) != s2Map.get(s2.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(CheckIsomorph("add", "egg"));
        System.out.println(CheckIsomorph("foo", "bar"));
        System.out.println(CheckIsomorph("paper", "title"));
        System.out.println(CheckIsomorph("notese", "codees"));
        System.out.println(CheckIsomorph("aababc", "bbcbcz"));
        System.out.println(CheckIsomorph("aaaww", "wwwaa"));
        System.out.println(CheckIsomorph("aab", "bbb"));
        System.out.println(CheckIsomorph("test", "best"));
    }
}
