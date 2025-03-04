import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int min_x = 51, min_y = 51;
        int max_x = 0, max_y = 0;
        
        //String iter 이후 char iter
        int cnt_row = 0;
        for (String line : wallpaper) {
            int cnt_col = 0;
            for(char ch : line.toCharArray()) {
                if (ch == '#') {
                    min_x = Math.min(cnt_row, min_x);
                    min_y = Math.min(cnt_col, min_y);
                    max_x = Math.max(cnt_row + 1, max_x);
                    max_y = Math.max(cnt_col + 1, max_y);
                }
                cnt_col++;
            }
            cnt_row++;
        }
        int[] answer = new int[] {min_x, min_y, max_x, max_y};
        
        return answer;
    }
}