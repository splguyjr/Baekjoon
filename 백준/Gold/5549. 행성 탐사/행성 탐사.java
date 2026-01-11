import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static int[][] map;
    static int[][][] prefix;

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        prefix = new int[n + 1][m + 1][3];

        k = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                if (line.charAt(j - 1) == 'J') {
                    prefix[i][j][0] += prefix[i - 1][j][0] + prefix[i][j - 1][0] - prefix[i - 1][j - 1][0] + 1;
                    prefix[i][j][1] += prefix[i - 1][j][1] + prefix[i][j - 1][1] - prefix[i - 1][j - 1][1];
                    prefix[i][j][2] += prefix[i - 1][j][2] + prefix[i][j - 1][2] - prefix[i - 1][j - 1][2];
                }
                else if (line.charAt(j - 1) == 'O') {
                    prefix[i][j][0] += prefix[i - 1][j][0] + prefix[i][j - 1][0] - prefix[i - 1][j - 1][0];
                    prefix[i][j][1] += prefix[i - 1][j][1] + prefix[i][j - 1][1] - prefix[i - 1][j - 1][1] + 1;
                    prefix[i][j][2] += prefix[i - 1][j][2] + prefix[i][j - 1][2] - prefix[i - 1][j - 1][2];
                }
                else {
                    prefix[i][j][0] += prefix[i - 1][j][0] + prefix[i][j - 1][0] - prefix[i - 1][j - 1][0];
                    prefix[i][j][1] += prefix[i - 1][j][1] + prefix[i][j - 1][1] - prefix[i - 1][j - 1][1];
                    prefix[i][j][2] += prefix[i - 1][j][2] + prefix[i][j - 1][2] - prefix[i - 1][j - 1][2] + 1;
                }

            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            calculatePrefixSum(a, b, c, d);
        }

        br.close();
    }

    private static void calculatePrefixSum(int a, int b, int c, int d) {
        int jCount = 0;
        int oCount = 0;
        int iCount = 0;

        jCount += prefix[c][d][0] - prefix[a - 1][d][0] - prefix[c][b - 1][0] + prefix[a - 1][b - 1][0];
        oCount += prefix[c][d][1] - prefix[a - 1][d][1] - prefix[c][b - 1][1] + prefix[a - 1][b - 1][1];
        iCount += prefix[c][d][2] - prefix[a - 1][d][2] - prefix[c][b - 1][2] + prefix[a - 1][b - 1][2];

        System.out.println(jCount + " " + oCount + " " + iCount);
    }

    public static void main(String[] args) throws IOException {
        Main.solve();
    }
}
