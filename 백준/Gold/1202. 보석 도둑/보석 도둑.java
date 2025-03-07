import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println(br.readLine());
        String[] line = br.readLine().split(" ");
        // n -> 보석 개수, k -> 가방 개수
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        List<Jewel> jewelList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            int m = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            jewelList.add(new Jewel(m, v));
        }
        jewelList.sort((j1, j2) -> j1.mass - j2.mass);

        // 각 가방에 담을 수 있는 최대 무게
        List<Integer> bagList = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            int c = Integer.parseInt(br.readLine());
            bagList.add(c);
        }
        Collections.sort(bagList);

        PriorityQueue<Jewel> pq = new PriorityQueue<>((j1, j2) -> j2.value - j1.value);

        long maxValueSum = 0;
        int idx = 0;
        for (int i = 0; i < k; i++) {
            // 무게 순으로 정렬된 리스트에서 앞에서부터 뽑은 무게가 현재 가방의 무게보다 작은 상황이면 뽑은 보석 무게가 더 커질 때까지 뽑음
            // 현재까지의 무게에 대해 뽑을 수 있는 보석을 우선순위큐에서 관리
            // idx < n 를 먼저 평가하여 indexOutOfRange 예외 방지
            while (idx < n && (jewelList.get(idx).mass <= bagList.get(i)) ) {
                pq.offer(new Jewel(jewelList.get(idx).mass, jewelList.get(idx).value));
                idx++;
            }

            if (!pq.isEmpty()) {
                maxValueSum += pq.poll().value;
            }
        }
        System.out.println(maxValueSum);
    }


    static class Jewel implements Comparable<Jewel>{
        int mass;
        int value;

        public Jewel(int mass, int value) {
            this.mass = mass;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            return this.mass - o.mass;
        }
    }
}