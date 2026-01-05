import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int mp, mf, ms, mv;
    static int[][] arr;
    static int[] cost;
    static int bestMask = 0;
    static int bestCost = Integer.MAX_VALUE;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        arr = new int[n][4];
        cost = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());

            cost[i] = Integer.parseInt(st.nextToken());
        }
    }
    
    private static void bruteforce(int idx, int p, int f, int s, int v, int curCost, int mask) {
        if (bestCost < curCost) return;

        if (p >= mp && f >= mf && s >= ms && v >= mv) {
            if (bestCost > curCost || (bestCost == curCost && compareOrder(mask, bestMask))) {
                bestCost = curCost;
                bestMask = mask;
            }
            return;
        }

        if (idx == n) {
            return;
        }

        else {
            int p1 = arr[idx][0];
            int f1 = arr[idx][1];
            int s1 = arr[idx][2];
            int v1 = arr[idx][3];
            int cost1 = cost[idx];


            bruteforce(idx + 1, p, f, s, v, curCost, mask);
            bruteforce(idx + 1, p + p1, f + f1, s + s1, v + v1, curCost + cost1, mask | (1 << idx));
        }

    }

    // 영양분과 비용이 모두 0인 에지 케이스 고려하기
    private static boolean compareOrder(int mask1, int mask2) {
        for (int i = 0; i < n; i++) {
            int bit1 = mask1 & (1 << i);
            int bit2 = mask2 & (1 << i);

            if (bit1 != bit2) return bit1 > bit2;
        }

        return false;
    }

    private static void printAnswer() {
        if (bestCost == Integer.MAX_VALUE) System.out.println(-1);

        else {
            System.out.println(bestCost);
            for (int i = 0; i < n; i++) {
                if ((bestMask & (1 << i)) != 0) {
                    System.out.print(i + 1 + " ");
                }
            }
        }
    }

    private static void solution() throws IOException {
        readInput();
        bruteforce(0, 0, 0, 0, 0, 0, 0);
        printAnswer();
    }
    
    public static void main(String[] args) throws IOException {
        Main.solution();

    }
}
