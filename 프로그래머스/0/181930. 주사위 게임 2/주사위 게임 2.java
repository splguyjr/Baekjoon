class Solution {
    public double solution(int a, int b, int c) {
        double answer = 0;
        
        double sum = a+b+c;
        double a2 = Math.pow(a,2);
        double b2 = Math.pow(b,2);
        double c2 = Math.pow(c,2);
        double sum1 = a2+b2+c2;
        double a3 = Math.pow(a,3);
        double b3 = Math.pow(b,3);
        double c3 = Math.pow(c,3);
        double sum2 = a3+b3+c3;
        
        
        if(a ==b) {
            if(b==c) answer = sum * sum1 * sum2;
            else answer = sum * sum1;
        }
        
        else {
            if (a == c) answer = sum * sum1;
            else if (b == c) answer = sum * sum1;
            else answer = sum;
        }
        
        
        return answer;
    }
}