class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String temp = "";
        String temp2 = "";
        for(int x : num_list) {
            if(x % 2 == 1) {
                temp += Integer.toString(x);
            }
            else temp2 += Integer.toString(x);
        }
        
        answer = Integer.parseInt(temp) + Integer.parseInt(temp2);
        
        return answer;
    }
}