class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String c = Integer.toString(a);
        String d = Integer.toString(b);
        
        answer = Integer.parseInt( Integer.parseInt(c+d) > Integer.parseInt(d+c) ? (c+d) : (d+c));
        
        return answer;
    }
}