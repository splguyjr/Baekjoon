// 20! 순열은 시간복잡도 상 불가능한 접근이라고 판단 -> 앞에서부터 자릿수 기준으로 (n-1)! 빼면서 인덱스 구하고, 남은 숫자 셋 정렬 유지하면서 인덱스 숫자 뽑아서 하나씩 넣어줘야 함, 너무 귀찮은데..
// 그냥 순열로 해도 되나? -> 절대 안되는데
import java.util.*;

class Solution {
    static long[] fact;
    static List<Integer> nums = new ArrayList<>();
    static List<Integer> ans = new ArrayList<>();
    
    public List<Integer> solution(int n, long k) {
        
        // 1~(n-1)!
        fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        
        long rem = k - 1;
        // 재귀 함수 기반으로 앞에서부터 빼기
        for (int i = n - 1; i >= 1; i--) {
            int q = (int) (rem / fact[i]);
            rem = rem % fact[i];
            ans.add(nums.remove(q));
        }
        ans.add(nums.get(0));
        
        return ans;
    }
    
}