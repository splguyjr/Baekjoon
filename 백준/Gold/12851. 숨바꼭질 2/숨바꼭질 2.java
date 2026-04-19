import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, k;
    static Queue<Integer> q = new LinkedList<>();
    static int[] visited;
    static int ans = 0;

    private static void readInput() throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        visited = new int[200001];
        Arrays.fill(visited, -1);
    }

    private static void bfs() {
        q.add(n);
        visited[n] = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                int x = q.poll();
                if (x == k) {
                    ans++;
                    flag = true;
                    continue;
                }

                if (2 * x <= 100000 && visited[2 * x] == -1 || visited[2 * x] == visited[x] + 1) {
                    visited[2 * x] = visited[x] + 1;
                    q.add(2 * x);
                }

                if (x + 1 <= 100000 && (visited[x + 1] == -1 || visited[x + 1] == visited[x] + 1)) {
                    visited[x + 1] = visited[x] + 1;
                    q.add(x + 1);
                }

                if (x - 1 >= 0 && (visited[x - 1] == -1 || visited[x - 1] == visited[x] + 1)) {
                    visited[x - 1] = visited[x] + 1;
                    q.add(x - 1);
                }
            }

            if (flag) break;
        }
    }

    private static void printAnswer() {
        System.out.println(visited[k]);
        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
        bfs();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
