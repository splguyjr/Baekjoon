import java.util.*;

class Solution {
    public int solution(String s) {
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            s = s.substring(1, len) + s.substring(0,1); // 왼쪽으로 한칸씩 밀기
            Stack<Character> st = new Stack<>();
            boolean check = true;
            
            for (char c : s.toCharArray()) {
                if (c == '[' || c == '(' || c == '{') {
                    st.push(c);
                }
                
                else if (c == ']') {
                    if (st.isEmpty()) {
                        check = false;
                        break;
                    }
                    if (!st.pop().equals('[')) {
                        check = false;
                        break;
                    }
                }
                
                else if (c == ')') {
                    if (st.isEmpty()) {
                        check = false;
                        break;
                    }
                    if (!st.pop().equals('(')) {
                        check = false;
                        break;
                    }
                }
                
                else if (c == '}') {
                    if (st.isEmpty()) {
                        check = false;
                        break;
                    }
                    if (!st.pop().equals('{')) {
                        check = false;
                        break;
                    }
                }
            }
            if (!st.isEmpty()) ans = 0;
            else if (check) ans += 1;
            
        }
        
        return ans;
    }
}