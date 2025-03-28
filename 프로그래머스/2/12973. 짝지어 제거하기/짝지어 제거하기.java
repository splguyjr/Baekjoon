import java.util.*;

class Solution
{
    
    public int solution(String s)
    {
        Stack<Character> st = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek() == c) {
                st.pop();
            } else {
                st.push(c);
            }
        }
        
        if (!st.isEmpty()) return 0;
        
        return 1;
    }
    
}