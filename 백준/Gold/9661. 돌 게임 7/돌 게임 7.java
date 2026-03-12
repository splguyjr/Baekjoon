import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long n;
    static boolean[] dp;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());

        if (n % 5 == 2 || n % 5 == 0) System.out.println("CY");
        else System.out.println("SK");
//        dp = new boolean[n + 1];
//
//        for (int i = 1; i <= n; i++) {
//            boolean check = false;
//            for (int j = 0; Math.pow(4, j) <= i; j++) {
//                if (!dp[i - (int)Math.pow(4, j)]) {
//                    check = true;
//                    break;
//                }
//            }
//            if (check) dp[i] = true;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            if (dp[i]) System.out.println(1);
//            else System.out.println(0);
//        }
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
