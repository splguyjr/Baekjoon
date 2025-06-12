import java.util.*;

class Solution {
    static int[] answer = {-1};
    static int[] lion = new int[11];
    static int max = 0;
    public int[] solution(int n, int[] info) {
        dfs(info, 0, n);
        return answer;
    }
    
    // n이 화살의 개수, cnt가 몇 번째 화살인지
    private void dfs(int[] info, int cnt, int n) {
        if (cnt == n) {
            int appeach_point = 0;
            int lion_point = 0;
            // 10점 부터 0점 과녁까지 차이를 통해 점수 구해서 최대인 경우 기록해 두기
            for (int i = 0; i <= 10; i++) {
                // 둘 다 0점인 경우 점수
                if(info[i] == 0 && lion[i] == 0) {
                    continue;
                }
                else if(info[i] < lion[i]) {
                    lion_point += 10 - i;
                }
                else {
                    appeach_point += 10 - i;
                }
                    
            }
            // lion의 점수가 appeach 보다 높으면서 최대인지 확인
            // 가장 나중에 기록된 max일수록 가장 낮은 점수의 화살을 많이 쐈으므로 >가 아닌 >=로 처리
            if (lion_point > appeach_point && lion_point - appeach_point >= max) {
                answer = lion.clone();
                max = lion_point - appeach_point;
            }
            return;
        }
        
        // 0 -> 10점, 10 -> 0점, lion이 맞힌 과녁 개수가 어피치의 +1이 될때까지만
        for (int i = 0; i <= 10 && lion[i] <= info[i]; i++) {
            lion[i]++;
            dfs(info, cnt+1, n);
            lion[i]--;
        }
    }
    
}