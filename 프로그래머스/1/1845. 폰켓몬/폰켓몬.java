import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int num = nums.length/2;
        
        Set<Integer> s = new HashSet<>();
        
        for (int x : nums) {
            s.add(x);
        }
        
        return s.size() < num ? s.size() : num;
    }
}