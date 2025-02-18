class Solution {
    public int[] solution(int[] num_list) {
        int s = num_list.length;
        int[] answer = new int[s+1];
        
        int a = num_list[s-2];
        int b = num_list[s-1];
        int c;
        if(a < b) c = b - a;
        else {c = 2 * b;}
        
        for(int i = 0; i < s; i++) {
            answer[i] = num_list[i];
        }
        
        answer[s] = c;
        
        
        return answer;
    }
}