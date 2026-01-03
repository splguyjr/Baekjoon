import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static char[][] map;
    static boolean[] visited;
    static int maxCount = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }

    private static void bfs() {
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;

            Queue<Integer> q = new LinkedList<>();
            q.add(i);

            int depth = 0;
            int count = 0;

            while (depth < 2) {
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    int x = q.poll();

                    for (int k = 0; k < n; k++) {
                        if (map[x][k] == 'Y' && !visited[k]) {
                            count++;
                            q.add(k);
                            visited[k] = true;
                        }
                    }
                }
                depth++;
            }

            maxCount = Math.max(maxCount, count);
        }
    }

    private static void printAnswer() {
        System.out.println(maxCount);
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
