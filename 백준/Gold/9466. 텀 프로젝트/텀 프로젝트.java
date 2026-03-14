import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int t;
    static int n;
    static int[] arr;
    static int[] state;
    static int cnt;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            state = new int[n + 1];
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            checkTeam();
            printAnswer();
        }
    }

    private static void checkTeam() {
        for (int i = 1; i <= n; i++) {
            if (state[i] == 0) dfs(i);
        }
    }

    private static void dfs(int x) {
        state[x] = 1;
        int next = arr[x];

        // 다음 정점이 미방문이면 계속 탐색
        if (state[next] == 0) {
            dfs(next);
        }

        // 이미 방문했던 적이 있는 정점이라면 사이클 형성
        else if (state[next] == 1) {
            cnt++;
            for (int i = next; arr[i] != next; i = arr[i]) cnt++;
        }

        state[x] = 2;
    }

    private static void printAnswer() {
        System.out.println(n - cnt);
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
