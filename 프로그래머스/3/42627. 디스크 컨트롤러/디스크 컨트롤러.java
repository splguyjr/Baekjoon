import java.util.*;

class Solution {
    static PriorityQueue<Task> pq = new PriorityQueue<>();
    
    static class Task implements Comparable<Task> {
        int len;
        int startTime;
        int num;
        
        Task(int len, int startTime, int num) {
            this.len = len;
            this.startTime = startTime;
            this.num = num;
        }
        
        //우선순위 -> 작업의 소요시간, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것
        @Override
        public int compareTo(Task t) {
            if (this.len != t.len) return Integer.compare(this.len, t.len);
            else if (this.startTime != t.startTime) return Integer.compare(this.startTime, t.startTime);
            return Integer.compare(this.num, t.num);
        }
    }
    
    public int solution(int[][] jobs) {
        // startTime 기준 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<Task> pq = new PriorityQueue<>();
        int time = 0, total = 0, idx = 0, n = jobs.length;

        while (idx < n || !pq.isEmpty()) {
            // 현재 시각까지 도착한 작업 모두 pq에 추가
            while (idx < n && jobs[idx][0] <= time) {
                pq.offer(new Task(jobs[idx][1], jobs[idx][0], idx));
                idx++;
            }

            if (pq.isEmpty()) {
                // 아직 도착한 작업 없으면 다음 작업 시작 시각으로 점프
                time = jobs[idx][0];
                continue;
            }

            Task task = pq.poll();
            time += task.len;
            total += time - task.startTime;
        }

        return total / n;
    }
}