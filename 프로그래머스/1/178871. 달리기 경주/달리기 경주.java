import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> m = new HashMap<>();
        int idx = 0;
        for(String s : players) {
            m.put(s, idx++);
        }
        
        for (String s : callings) {
            int idx1 = m.get(s);//명단에 들어가 있는 선수의 위치
            int idx2 = idx1 - 1;//s2, 앞 선수 인덱스
            
            //players 배열 업데이트
            String s2 = players[idx2];
            players[idx2] = s;
            players[idx1] = s2;
            
            //map 업데이트
            m.put(s, idx2);
            m.put(s2, idx1);
        }  
    
        return players;
    }
}