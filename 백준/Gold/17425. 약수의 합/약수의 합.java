import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int t;
    static long[] divisorSum;
    static long[] prefixSum;
    static final int max = 1000000;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        divisorSum = new long[1000001];
        prefixSum = new long[1000001];

        calculateDivisorSum();
        calculatePrefixSum();

        t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            
            sb.append(prefixSum[n]).append('\n');
        }

        System.out.println(sb.toString());
    }

    private static void calculateDivisorSum() {
        for (int i = 1; i <= max; i++) {
            for (int j = 1; i * j <= max; j++) {
                divisorSum[i * j] += i;
            }
        }
    }

    private static void calculatePrefixSum() {
        for (int i = 1; i <= max; i++) {
            prefixSum[i] = prefixSum[i - 1] + divisorSum[i];
        }
    }

    private static void solution() throws IOException {
        readInput();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
