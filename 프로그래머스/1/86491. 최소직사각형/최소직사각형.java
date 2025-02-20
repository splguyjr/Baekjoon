class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int a = 0, b = 0;
        
        for(int[] arr: sizes) {
            int w = Math.max(arr[0],arr[1]);
            int h = Math.min(arr[0],arr[1]);
            
            if (a < w && b < h) {
                a = Math.max(w,h);
                b = Math.min(w,h);
            }
            else if(a>=w && b >=h) continue;
            else {
                if(a<w) a = w;
                else if (b<h) b = h;
            }
            
        }
        return a * b;
    }
}