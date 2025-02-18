class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr;
        
        for(int[] x : queries) {
            int s = x[0];
            int e = x[1];
            int k = x[2];
            
            for(int i = s; i<=e; i++) {
                if(i % k  == 0) answer[i] += 1;
            }
        }
        return answer;
    }
}