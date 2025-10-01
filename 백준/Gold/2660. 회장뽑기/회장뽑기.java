import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static List<Integer>[] graph;
    static int[] score;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Node {
        int num;
        int turn;   // 삽입된 턴을 추적

        Node(int num, int turn) {
            this.num = num;
            this.turn = turn;
        }
    }

    private static void readInput() throws IOException {
        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        score = new int[n + 1];

        while (true) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;

            // 양방향 간선
            graph[a].add(b);
            graph[b].add(a);
        }
    }

    private static void bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        q.offer(new Node(start, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            int idx = cur.num;
            int turn = cur.turn;

            if (visited[idx]) continue;

            visited[idx] = true;
            score[start] = Math.max(score[start], turn);

            for (int adj : graph[idx]) {
                q.offer(new Node(adj, turn + 1));
            }
        }
    }

    private static void calAnswer() {
        int mn = 51;
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            mn = Math.min(mn, score[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (score[i] == mn) list.add(i);
        }

        System.out.println(score[list.get(0)] + " " + list.size());
        for (int idx : list) {
            System.out.print(idx + " ");
        };
    }

    private static void solution() throws IOException {
        readInput();
        for (int i = 1; i <= n; i++) {
            bfs(i);
        }
        calAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}