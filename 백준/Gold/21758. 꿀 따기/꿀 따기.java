import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long[] prefixSum;
    static long maxAmount = 0;   // 1 ~ n-2위치 중 최대를 저장

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        prefixSum = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int amount = Integer.parseInt(st.nextToken());

            if (i == 0) prefixSum[i] = amount;

            else {
                if (i != n - 1) {
                    maxAmount = Math.max(maxAmount, amount);
                }
                prefixSum[i] = prefixSum[i - 1] + amount;
            }
        }
    }

    private static long compareCase() {
        long maxCount = 0;

        // 벌벌 - 꿀통
        for (int i = 1; i < n - 1; i++) {
            long sum1 = prefixSum[i - 1] - prefixSum[0];
            long sum2 = prefixSum[n - 1] - prefixSum[i];
            maxCount = Math.max(maxCount, sum1 + sum2 * 2);
        }

        // 꿀통 - 벌벌
        for (int i = 1; i < n - 1; i++) {
            long sum1 = prefixSum[i - 1];
            long sum2 = prefixSum[n - 2] - prefixSum[i];
            maxCount = Math.max(maxCount, sum1 * 2 + sum2);
        }

        // 벌 - 꿀통 - 벌
        maxCount = Math.max(maxCount, prefixSum[n - 2] - prefixSum[0] + maxAmount);

        return maxCount;
    }

    private static void printAnswer() {
        System.out.println(compareCase());
    }

    private static void solution() throws IOException {
        readInput();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
