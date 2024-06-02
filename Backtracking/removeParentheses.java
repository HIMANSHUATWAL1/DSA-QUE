package Backtracking;
// QUESTION->

//An expression will be given which can contain open and close parentheses and optionally some characters, No other operator will be there in string. We need to remove minimum number of parentheses to make the input string valid. If more than one valid output are possible removing same number of parentheses then print all such output. 

// mra----> minimum removal allowed.

import java.util.*;

public class removeParentheses {

    public static void solution(String str, int mra, HashSet<String> ans) {
        if (mra == 0) {
            int mrNow = getMinRemove(str);
            if (mrNow == 0) {
                if (!ans.contains(str)) {
                    System.out.println(str);
                    ans.add(str);
                }

            }
        }

        for (int i = 0; i < str.length(); i++) {
            // we have to remove i'th character from string

            // left side character from i
            String left = str.substring(0, i);

            // right side character from i
            String right = str.substring(i + 1);

            // recursive call for all possible removal to get valid answer-->

            solution(left + right, mra - 1, ans);

        }
    }

    public static int getMinRemove(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.size() == 0) {
                    st.push(ch);
                } else if (st.peek() == ')') {
                    st.push(ch);
                } else if (st.peek() == '(') {
                    st.pop();
                }
            }
        }
        return st.size();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.println("enter your string :");
        String str = sc.next();

        int mr = getMinRemove(str);
        solution(str, mr, new HashSet<>());
    }

}
