import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> st = new Stack<>();
        
        for (int move : moves) {
            int doll = select(move - 1, board);
            
            if (doll == -1) continue;
            
            if (st.isEmpty()) {
                st.push(doll);
                continue;
            }
            
            else {
                if (st.peek() == doll) {
                    answer += 2;
                    st.pop();
                } 
                else {
                    st.push(doll);
                }
            }
        }
        
        return answer;
    }
    
    // 뽑고 인형 자리 비움
    private int select(int colIdx, int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][colIdx] != 0) {
                int pop = board[i][colIdx];
                board[i][colIdx] = 0;
                return pop;
            }
        }
        
        return -1;
    }
    
}