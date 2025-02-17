class Solution {
    public String solution(String myString) {
        String answer = "";
        
        String temp = myString.toLowerCase();
        for(char ch : temp.toCharArray()) {
            if (ch == 'a') answer += 'A';
            else answer+= ch;
        }
        // for(char ch : myString.toCharArray()) {
        //     if (ch == 'a') answer += 'A';
        //     else {
        //         if(ch >= 65 && ch <= 90) answer += (char)(ch + 32);    
        //         else answer += ch;
        //     }
        // }
        return answer;
    }
}