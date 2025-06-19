import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        List<String> list = new ArrayList<>();
        
        for (String s : strings) {
            list.add(s);
        }
        
        list.sort((s1, s2) -> {
            int result = s1.charAt(n) - s2.charAt(n);
            if (result == 0) return s1.compareTo(s2);
            return result;
            }
        );
        
        String[] answer = list.toArray(new String[0]);
        return answer;
    }
}