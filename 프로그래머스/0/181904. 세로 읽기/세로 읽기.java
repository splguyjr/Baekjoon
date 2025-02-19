class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        char[] carr = my_string.toCharArray();
        
        for (int i = 0; i < carr.length; i++) {
            if((i % m) + 1 == c) {
                answer += carr[i];
            }
        }
        return answer;
    }
}