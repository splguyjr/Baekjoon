import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] prefix;
    static int maxProfit = Integer.MIN_VALUE;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        prefix = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void bruteForce() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= Math.min(i, j) ; k++) {
                    maxProfit = Math.max(maxProfit, calculateSquare(i, j, k));
                }
            }
        }
    }

    private static int calculateSquare(int a, int b, int size) {
        return prefix[a][b] - prefix[a - size][b] - prefix[a][b - size] + prefix[a - size][b - size];
    }

    private static void printAnswer() {
        System.out.println(maxProfit);
    }

    public static void main(String[] args) throws IOException {
        readInput();
        bruteForce();
        printAnswer();
    }
}
