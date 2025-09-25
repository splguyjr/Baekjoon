import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, m;
    static int[][] map;
    static int maskSize;    // 비트마스킹 최대크기 = (1 << n * m) - 1
    static int answer = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void readInput() throws IOException {
        String line = br.readLine();
        String[] sarr = line.split(" ");
        n = Integer.parseInt(sarr[0]);
        m = Integer.parseInt(sarr[1]);

        map = new int[n][m];
        maskSize = (1 << n * m) - 1;

        for (int i = 0; i < n; i++) {
            line = br.readLine();

            int j = 0;
            for (char c : line.toCharArray()) {
                map[i][j] = c - '0';
                j++;
            }
        }
    }

    private static void bruteforce() {
        // 0이면 해당자리는 가로 직사각형에 속하는 것으로 취급
        for (int i = 0; i <= maskSize; i++) {
            answer = Math.max(answer, calulateSum(i));
        }
    }

    // 처음에는 dfs + visited 배열을 통해 전체 탐색하면서 더하는 구현 고려
    // 그냥 가로로 한번 훑고 세로로 한번 훑기로 구현하는 것이 더 간단 -> 반대가 나올때까지 10 곱하고 더하면 됨
    private static int calulateSum(int mask) {
        int sum = 0;

        // 가로 스캐닝
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < m; j++) {
                int bit = i * m + j; // (0,0) -> 0, (3,3) -> 15
                if ((mask & (1 << bit)) == 0) rowSum = rowSum * 10 + map[i][j];
                else {
                    sum += rowSum;
                    rowSum = 0;
                }
            }
            sum += rowSum;
        }

        // 세로 스캐닝
        for (int j = 0; j < m; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                int bit = i * m + j; // (0,0) -> 0, (3,3) -> 15
                if ((mask & (1 << bit)) != 0) colSum = colSum * 10 + map[i][j];
                else {
                    sum += colSum;
                    colSum = 0;
                }
            }
            sum += colSum;
        }

        return sum;
    }
    private static void solution() throws IOException {
        readInput();
        bruteforce();
        System.out.println(answer);
    }


    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}