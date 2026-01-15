import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] health;
    static int[] weight;
    static int ans = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        health = new int[n];
        weight = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            health[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void dfs(int curIdx, int cnt) {
        if (curIdx == n) {
            ans = Math.max(ans, cnt);
            return;
        }

        if (health[curIdx] <= 0 || cnt == n - 1) {
            dfs(curIdx + 1, cnt);
            return;
        }

        // i는 깨려는 계란의 인덱스를 의미
        for (int i = 0; i < n; i++) {
            // 현재 들고 있는 계란이거나, 이미 깨진 계란인 경우 스킵
            if (i == curIdx || health[i] <= 0) continue;

            int w1 = weight[curIdx];
            int w2 = weight[i];

            health[curIdx] -= w2;
            health[i] -= w1;

            if (health[curIdx] <= 0) cnt += 1;
            if (health[i] <= 0) cnt += 1;
            dfs(curIdx + 1, cnt);
            if (health[curIdx] <= 0) cnt -= 1;
            if (health[i] <= 0) cnt -= 1;

            health[curIdx] += w2;
            health[i] += w1;
        }
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        readInput();
        dfs(0, 0);
        printAnswer();
    }
}
