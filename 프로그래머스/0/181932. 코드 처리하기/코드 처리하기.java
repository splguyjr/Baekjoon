class Solution {
    public String solution(String code) {
        String answer = "";
        boolean flag = true;//참이면 짝수번째 더함
        
        for(int idx =0; idx<code.length(); idx++) {
            if(code.charAt(idx) == '1') {
                flag = flag ? false : true;
                continue;
            } 
            else if (code.charAt(idx) == '0') {
                flag = true;
                continue;
            }
            if (!flag && idx % 2 == 1)
                answer += code.charAt(idx);
            if (flag && idx % 2 == 0)
                answer += code.charAt(idx);
        }
        
        if(answer == "")
            return "EMPTY";
        
        return answer;
    }
}