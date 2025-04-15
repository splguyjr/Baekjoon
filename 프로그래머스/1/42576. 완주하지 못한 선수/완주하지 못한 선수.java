import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        for (String p : completion) {
            map.put(p, map.get(p) - 1);
        }
        
        List<String> list = map.keySet().stream().filter(key -> map.get(key) == 1).collect(Collectors.toList());
        
        return list.get(0);
    }
}