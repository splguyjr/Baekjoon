import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> m = new HashMap<>();
        for(int i = 0; i < name.length; i++) {
            m.put(name[i], yearning[i]);
        }
        
        int cnt = 0;
        for(String[] sarr : photo) {
            int ans = 0;
            for(String person : sarr) {
                if (m.containsKey(person)) {
                    ans += m.get(person);
                }
            }
            answer[cnt++] = ans;
        }
        return answer;
    }
}