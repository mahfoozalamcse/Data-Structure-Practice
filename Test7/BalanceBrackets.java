package Test7;

import java.util.Stack;

public class BalanceBrackets {
    // Balanced Brackets

    public static String isBalanced(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);

            } else if (ch == ')' || ch == '}' || ch == ']') {

                if (st.isEmpty()) {
                    return "NO";
                }

                char c = st.pop();

                if (ch == '(' && c != ')') {
                    return "NO";
                }

                if (ch == '{' && c != '}') {
                    return "NO";
                }

                if (ch == '[' && c != ']') {
                    return "NO";
                }
            }
        }
        return st.isEmpty() ? "YES" : "NO";

    }

    public static void main(String[] args) {
        
      String s = "[{()}]";
      System.out.println("Output : ");
      System.out.println(isBalanced(s));
    }
}
