import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        //빈도수 map에 기록
        for(int x : new int[] {a,b,c,d})
            map.put(x, map.getOrDefault(x, 0) + 1);
        
        //map .keySet(), values()
        List<Integer> keys = new ArrayList<>(map.keySet());
        List<Integer> vals = new ArrayList<>(map.values());
        
        if(keys.size() == 1) {
            answer = 1111 * keys.get(0);
        }
        
        //(3,1), (2,2), (2,1,1)
        else if (keys.size() == 2) {
            if(vals.contains(3)) {
                answer = (int)Math.pow((10 * keys.get(vals.indexOf(3)) + keys.get(vals.indexOf(1))), 2);
            }
            
            else {
                int sum = 0;
                int sub = 0;
                for(int x : keys) {
                    sum += x;
                    if(sub == 0) sub+=x;
                    else sub = sub > x ? sub-x:Math.abs(sub-x);
                }
                answer = sum * sub;
            }
        }
        
        else if (keys.size() == 3) {
                answer = 1;
                for(int x : keys) {
                    if(map.get(x) == 1) {
                          answer *= x;
                    }
                }
        }
        
        else answer = Math.min(Math.min(Math.min(a,b),c),d);
        
        return answer;
    }
}