class Solution {
    static int ans = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return ans;
    }
    
    private void dfs(int[] numbers, int target, int cnt, int sum) {
        if (cnt == numbers.length) {
            if (sum == target) ans++;
            return;
        }
        
        dfs(numbers, target, cnt + 1, sum + numbers[cnt]);
        dfs(numbers, target, cnt + 1, sum - numbers[cnt]);
        
        return;
    }
}