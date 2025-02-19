class Solution {
    public int solution(String number) {
        int answer = 0;
        
        for(char c : number.toCharArray()) {
            answer = (answer + (c-'0')) % 9;
        }
        
        return answer;
    }
}