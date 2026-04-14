import java.io.IOException;
import java.util.*;

public class Main {

    static int n, k;
    static int[] visited;
    static int[] prev;
    static int mx = 100000;

    private static void readInput() throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        visited = new int[100001];
        Arrays.fill(visited, -1);
        prev = new int[100001];
    }

    private static void bfs(int st) {
        Queue<Integer> q = new LinkedList<>();

        q.add(st);
        visited[st] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x == k) break;

            if (2 * x <= mx && visited[2 * x] == -1) {
                visited[2 * x] = visited[x] + 1;
                prev[2 * x] = x;
                q.add(2 * x);
            }

            if (x + 1 <= mx && visited[x + 1] == -1) {
                visited[x + 1] = visited[x] + 1;
                prev[x + 1] = x;
                q.add(x + 1);
            }

            if (x - 1 >= 0 && visited[x - 1] == -1) {
                visited[x - 1] = visited[x] + 1;
                prev[x - 1] = x;
                q.add(x - 1);
            }
        }
    }

    private static void printAnswer() {
        System.out.println(visited[k]);

        Stack<Integer> st = new Stack<>();
        for (int i = k; i != n; i = prev[i]) {
            st.add(i);
        }
        st.add(n);

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    private static void solution() throws IOException {
        readInput();
        bfs(n);
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
