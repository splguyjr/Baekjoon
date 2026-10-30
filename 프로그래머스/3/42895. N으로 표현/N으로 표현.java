import java.util.*;

class Solution {
    
    // S(1) = 5
    // S(2) = {5*10 + 5, 5+5, 5-5, 5*5, 5/5}
    static List<Set<Integer>> state = new ArrayList<>();
    public int solution(int N, int number) {
        for (int i = 0; i <= 8; i++) {
            state.add(new HashSet<>());
        }
        
        for (int i = 1; i <= 8; i++) {
            state.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            for (int j = 1; j < i; j++) {
                int a = j;
                int b = i - j;
                for (int x : state.get(a)) {
                    for (int y : state.get(b)) {
                        // xy, x+y, x-y, x*y, x/y
                        state.get(i).add(x + y);
                        state.get(i).add(x - y);
                        state.get(i).add(x * y);
                        if (y != 0) state.get(i).add(x / y);
                    }
                }
            }
            if (state.get(i).contains(number)) return i;
        }
        
        return -1;
    }
}