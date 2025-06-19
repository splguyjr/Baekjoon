import java.util.*;

class Solution {
    public long solution(long n) {     
        String num = String.valueOf(n);
        
        long answer = 0;
        List<Character> clist = new ArrayList<>();
        
        for (char ch : num.toCharArray()) {
            clist.add(ch);
        }
        
        clist.sort(Comparator.reverseOrder());
        for (char c : clist) {
            answer *= 10;
            answer += c - '0';
        }
        return answer;
    }
}