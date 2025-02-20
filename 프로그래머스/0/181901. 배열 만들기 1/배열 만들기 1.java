import java.util.*;

class Solution {
    public List solution(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = k; i <= n; i += k) {
            list.add(i);
        }
        return list;
    }
}