import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, h;
    static int[] up;    // 석순
    static int[] down;  // 종유석
    static int minCount = Integer.MAX_VALUE;
    static int count = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] sarr = line.split(" ");

        n = Integer.parseInt(sarr[0]);
        h = Integer.parseInt(sarr[1]);

        up = new int[h];
        down = new int[h];

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine()) - 1;

            if (i % 2 == 0) up[height]++;
            else down[height]++;
        }
    }

    // 해당 높이를 가진 석순, 종유석을 누적합으로 관리
    private static void prefixSum() {
        for (int i = h - 2; i >= 0; i--) {
            up[i] += up[i + 1];
            down[i] += down[i + 1];
        }
    }

    private static void countMin() {
        for (int i = 0; i < h; i++) {
            int obstacle = up[i] + down[h - i - 1];

            if (minCount > obstacle) {
                minCount = obstacle;
                count = 1;
            }

            else if (minCount == obstacle) count++;
        }
    }

    private static void printAnswer() {
        System.out.println(minCount + " " + count);
    }

    private static void solution() throws IOException {
        readInput();
        prefixSum();
        countMin();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
