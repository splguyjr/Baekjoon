import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        List<String> slist = new ArrayList<>();
        
        for (int x : numbers) {
            String s = String.valueOf(x);
            slist.add(s);
        }
        
        // (30,3)인 경우 303과 330(b+a)을 비교해서 앞이 더 크므로 a와 b자리를 swap
        answer = slist.stream()
            .sorted((a, b) -> (b + a).compareTo(a + b))
            .collect(Collectors.joining());
        
        if (answer.charAt(0) == '0') return "0";
        
        return answer;
    }
}