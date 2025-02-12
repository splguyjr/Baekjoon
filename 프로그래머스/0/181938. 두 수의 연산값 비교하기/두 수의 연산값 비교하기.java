class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String x = "" + a + b;
        String y = String.valueOf(2 *a *b);
        int c = Integer.parseInt(x);
        int d = Integer.parseInt(y);
        
        return c > d ? c : d;
    }
}