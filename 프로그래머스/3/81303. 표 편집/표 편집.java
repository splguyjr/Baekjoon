import java.util.*;

class Solution {
   public String solution(int n, int k, String[] cmd) {
       Stack<Integer> deleted = new Stack<>();
       // 각 행을 기준으로 연산에 따른 위치를 표시하기 위한 배열
       int[] up = new int[n + 2];
       int[] down = new int[n + 2];
       
       for (int i = 0; i < n + 2; i++) {
           up[i] = i - 1;
           down[i] = i + 1;
       }
       
       // 시작은 1행부터
       k += 1;
       
       for (String c : cmd) {
           if (c.startsWith("C")) {
               deleted.push(k);
               up[down[k]] = up[k];
               down[up[k]] = down[k];
               k = n < down[k] ? up[k] : down[k];
           }
           
           else if (c.startsWith("Z")) {
               int restore = deleted.pop();
               down[up[restore]] = restore;
               up[down[restore]] = restore;
           }
           
           else {
               String[] s = c.split(" ");
               int x = Integer.parseInt(s[1]);
               for (int i = 0; i < x; i++) {
                   k = s[0].equals("U") ? up[k] : down[k];   }
           }
       }
       
       char[] answer = new char[n];
       Arrays.fill(answer, 'O');
       
       for (int i : deleted) {
           answer[i-1] = 'X';
       }
       
       return new String(answer);
   }
        
        
// 정확성 테스트 올 통과, 효율성 테스트 시간 초과 코드
//      public String solution(int n, int k, String[] cmd) {
//         // table[1][0] = 0 -> 1번째 행 존재, table[1][0] = 1 -> 1번째 행 존재 X
//         int[][] table = new int[n][1];
//         int idx = k;
//         int lastRowIdx = n - 1; // 맨 마지막 행 idx 추적
//         Stack<Integer> poppedStack = new Stack<>();
        
//         for (String command : cmd) {
//             if (command.startsWith("U")) {
//                 String[] sarr = command.split(" ");
//                 int move = Integer.valueOf(sarr[1]);
//                 while (move > 0) {
//                     idx--;
//                     if (table[idx][0] == 0) move--;
//                 }
//             }
            
//             else if (command.startsWith("D")) {
//                 String[] sarr = command.split(" ");
//                 int move = Integer.valueOf(sarr[1]);
//                 while (move > 0) {
//                     idx++;
//                     if (table[idx][0] == 0) move--;
//                 }
//             }
            
//             // Stack에 삭제할 인덱스 저장, table 배열에 반영
//             else if (command.startsWith("C")) {
//                 poppedStack.push(idx);
//                 table[idx][0] = 1;
                
//                 //삭제한 행이 맨 마지막이었던 경우, 삭제되지 않은 행을 만날때까지 idx-1
//                 if (idx == lastRowIdx) {
//                     do {
//                         if (idx == 0) break;
//                         idx -= 1;}
//                     while (table[idx][0] == 1);
//                     lastRowIdx = idx;
//                 }
                
//                 //맨 마지막이 아니였던 경우, 삭제되지 않은 행을 만날 때까지 idx + 1
//                 else {
//                     do { idx++; } 
//                     while (idx < n && table[idx][0] == 1);
//                 }
//             }
            
//             else if (command.startsWith("Z")) {
//                 int restoreIdx = poppedStack.pop();
//                 if (restoreIdx > lastRowIdx) lastRowIdx = restoreIdx;
//                 table[restoreIdx][0] = 0;
//             }
            
            
//         }
        
//         StringBuilder sb = new StringBuilder();
        
//         for (int i = 0; i < n; i++) {
//             if (table[i][0] == 0) sb.append("O");
//             else sb.append("X");
//         }
        
        
//         return sb.toString();
//     }  
}
