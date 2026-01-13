import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static int[][] prefixBW;
    static int[][] prefixWB;
    static int ans = Integer.MAX_VALUE;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        prefixBW = new int[n + 1][m + 1];
        prefixWB = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                char ch = line.charAt(j - 1);

                boolean checkB = (i + j) % 2 == 0; // B가 먼저 오는 기준, BW 보드에 맞는 위치

                if (checkB) {
                    if (ch == 'B') {
                        prefixBW[i][j] += prefixBW[i - 1][j] + prefixBW[i][j - 1] - prefixBW[i - 1][j - 1];
                        prefixWB[i][j] += prefixWB[i - 1][j] + prefixWB[i][j - 1] - prefixWB[i - 1][j - 1] + 1;
                    }
                    else {
                        prefixBW[i][j] += prefixBW[i - 1][j] + prefixBW[i][j - 1] - prefixBW[i - 1][j - 1] + 1;
                        prefixWB[i][j] += prefixWB[i - 1][j] + prefixWB[i][j - 1] - prefixWB[i - 1][j - 1];
                    }
                }

                else {
                    if (ch == 'B') {
                        prefixBW[i][j] += prefixBW[i - 1][j] + prefixBW[i][j - 1] - prefixBW[i - 1][j - 1] + 1;
                        prefixWB[i][j] += prefixWB[i - 1][j] + prefixWB[i][j - 1] - prefixWB[i - 1][j - 1];
                    }
                    else {
                        prefixBW[i][j] += prefixBW[i - 1][j] + prefixBW[i][j - 1] - prefixBW[i - 1][j - 1];
                        prefixWB[i][j] += prefixWB[i - 1][j] + prefixWB[i][j - 1] - prefixWB[i - 1][j - 1] + 1;
                    }
                }
            }
        }
    }

    private static void bruteForce() {
        for (int i = 1; i <= n - k + 1; i++) {
            for (int j = 1; j <= m - k + 1; j++) {
                ans = Math.min(ans, calculateArea(i, j));
            }
        }
    }

    private static int calculateArea(int x, int y) {
        int bwCount = prefixBW[x + k - 1][y + k - 1] - prefixBW[x - 1][y + k - 1] - prefixBW[x + k - 1][y - 1] + prefixBW[x - 1][y - 1];
        int wbCount = prefixWB[x + k - 1][y + k - 1] - prefixWB[x - 1][y + k - 1] - prefixWB[x + k - 1][y - 1] + prefixWB[x - 1][y - 1];

        return Math.min(bwCount, wbCount);
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
        bruteForce();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
