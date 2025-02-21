class Solution {
    public int[] solution(int brown, int yellow) {
        
        int sum = brown + yellow;
        for(int i = 2; i<= (int)Math.sqrt(sum); i++) {
            int a=0,b=0;
            if(sum % i == 0) {
                a = Math.max(sum/i,i);
                b = Math.min(sum/i,i);
                if((2*(a+b)-4)== brown)
                    return new int[]{a,b};
            }
        }
        
        return null;
    }
}