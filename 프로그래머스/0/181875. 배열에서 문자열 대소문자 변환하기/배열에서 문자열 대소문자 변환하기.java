class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = new String[strArr.length];
        
        for (int i = 0; i < strArr.length; i++) {
            String s = strArr[i];
            if(i % 2 == 0) {
                answer[i] = s.toLowerCase();
            }
            else answer[i] = s.toUpperCase();
        }
        return answer;
    }
}