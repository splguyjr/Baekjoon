import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] dist;
    static int total = 0;
    static int ans = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dist = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.parseInt(br.readLine());
            total += dist[i];
        }
    }

    private static void checkAround() {
        int st = 0;
        int ed = 1;

        int clockWiseSum = dist[0];

        while (st <= ed && ed < n) {
            int counterClockWiseSum = total - clockWiseSum;

            int minSum = Math.min(clockWiseSum, counterClockWiseSum);
            ans = Math.max(ans, minSum);

            if (clockWiseSum <= counterClockWiseSum) {
                clockWiseSum += dist[ed];
                ed++;
            }

            else {
                clockWiseSum -= dist[st];
                st++;
            }
        }
    }

    private static void printAnswer() {
        System.out.println(ans);
    }
    
    private static void solution() throws IOException {
        readInput();
        checkAround();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
