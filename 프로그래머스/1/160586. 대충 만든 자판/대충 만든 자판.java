import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<String, Integer> km = new HashMap<>();
        
        for (String s : keymap) {
            int idx = 1;
            for (char c : s.toCharArray()) {
                if(km.containsKey(String.valueOf(c))) {
                    km.put(String.valueOf(c), Math.min(km.get(String.valueOf(c)), idx));
                }
                else {
                    km.put(String.valueOf(c), idx);
                }
                idx++;
            }
        }
        
        int[] answer = new int[targets.length];
        int idx = 0;
        for (String t : targets) {
            for (char c : t.toCharArray()) {
                if (!km.containsKey(String.valueOf(c))) {
                    answer[idx] = -1;
                    break;   
                }
                answer[idx] += km.get(String.valueOf(c));
            }
            idx++;
        }
        
        return answer;
    }
}