class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sum = 1;
        int sum2 = 0;
        
        for (int i = 0; i < num_list.length; i++) {
            sum *= num_list[i];
            sum2 += num_list[i];
        }
        
        return sum < Math.pow(sum2, 2) ? 1 : 0;
    }
}