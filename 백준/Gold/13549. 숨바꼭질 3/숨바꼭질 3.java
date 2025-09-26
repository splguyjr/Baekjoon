import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, k;
    static int mx = 100000;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[100001];
    static Queue<Node> q = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    static class Node {
        int cur;
        int time;

        Node(int cur, int time) {
            this.cur = cur;
            this.time = time;
        }
    }

    private static void readInput() {
        n = sc.nextInt();
        k = sc.nextInt();
    }

    private static void bfs(Node node) {
        q.offer(node);

        while (!q.isEmpty()) {
            Node curNode = q.poll();
            int cur = curNode.cur;
            int time = curNode.time;

            visited[cur] = true;

            if (cur == k) {
                answer = Math.min(answer, time);
            }

            if (cur * 2 <= mx && !visited[cur * 2]) {
                q.offer(new Node(cur * 2, time));
            }

            if (cur + 1 <= mx && !visited[cur + 1]) {
                q.offer(new Node(cur + 1, time + 1));
            }

            if (cur - 1 >= 0 && !visited[cur - 1]) {
                q.offer(new Node(cur - 1, time + 1));
            }
        }
    }

    private static void solution() {
        readInput();
        bfs(new Node(n,0));
        System.out.println(answer);
    }

    public static void main(String[] args) {
        Main.solution();
    }
}