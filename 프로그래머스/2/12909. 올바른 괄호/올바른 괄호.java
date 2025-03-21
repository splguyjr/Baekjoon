import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> st = new Stack<>();
        
        for (char pt : s.toCharArray()) {
            if(pt == '(') st.push(pt);
            else {
                if (st.isEmpty()) return false;
                else {
                    st.pop();
                }
            }
        }
        
        if (!st.isEmpty()) return false;
        return true;
    }
}