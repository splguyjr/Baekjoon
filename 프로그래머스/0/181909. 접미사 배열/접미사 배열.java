import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        int len = my_string.length();
        String[] answer = new String[len];
        
        for(int i = len-1; i >= 0; i--) {
            String s = my_string.substring(i, len);
            answer[i] = s;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}