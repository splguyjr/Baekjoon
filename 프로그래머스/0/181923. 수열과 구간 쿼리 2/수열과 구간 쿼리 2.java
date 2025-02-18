class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int cnt = 0;
        for(int[] x : queries) {
            int st = x[0];
            int ed = x[1];
            int num = x[2];
            
            int min = 1000001;
            for(int i = st; i<=ed; i++) {
                if(arr[i] < min && arr[i] > num) min = arr[i];
            }
            if(min == 1000001) min = -1;
            answer[cnt] = min;
            cnt++;
        }
        
        return answer;
    }
}