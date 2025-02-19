class Solution {
    public String solution(String my_string, int[][] queries) {
       String last = my_string;
        
        for(int[] arr : queries) {
            int x = arr[0];
            int y = arr[1];
            
            String temp = "";
            int cnt = 0;
            
            for (int i = 0; i < my_string.length(); i++) {
                if (i >= x && i <= y) {
                    temp += last.charAt(y-cnt);
                    cnt++;
                }
                else
                    temp += last.charAt(i);
            }
            last = temp;
        }
        return last;
    }
}