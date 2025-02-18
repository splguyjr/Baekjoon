class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr;
        
        for(int[] x : queries) {
            int i = x[0];
            int j = x[1];
            
            int a = arr[i];
            int b = arr[j];
            
            int temp = a;
            answer[i] = b;
            answer[j] = temp;
        }
        return answer;
    }
}