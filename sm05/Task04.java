// Необходимо проверить корректность открытия/закрытия разного типа скобок в выражении

package sm05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Task04 {
    public static boolean CheckParentheses(String s) {
        Stack<Character> st = new Stack<Character>();
        List<Character> parentheses = new ArrayList<Character>(Arrays.asList('(', ')', '[', ']', '{', '}', '<', '>'));
        for (int i = 0; i < s.length(); i++) {
            if (parentheses.contains(s.charAt(i))) {
                switch (s.charAt(i)) {
                case '(', '[', '{', '<':
                    st.push(s.charAt(i));
                    break;
                case ')', ']', '}', '>':
                    if (st.isEmpty()) return false;
                    char top = st.pop();
                    if (s.charAt(i) != parentheses.get(parentheses.indexOf(top) + 1)) {
                        return false;
                    }                    
                    break;                   
                }
            }
        }
        if (!st.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(CheckParentheses("[()]{}{[()()]()}"));
        System.out.println(CheckParentheses("[]<{}>"));
        System.out.println(CheckParentheses("[]{"));
        System.out.println(CheckParentheses("[]>"));
        System.out.println(CheckParentheses(">"));
        System.out.println(CheckParentheses("("));
        System.out.println(CheckParentheses("(>"));
    }
}
