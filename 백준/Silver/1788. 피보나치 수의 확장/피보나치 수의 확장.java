import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static int[] fibo = new int[1000001];
    
    // -3 2 -1 1 0 1

    private int dp(int n) {
        if (n < 0) {
            n = Math.abs(n);

            for (int i = 2; i <= n; i++) {
                fibo[i] = (fibo[i-2] - fibo[i-1]) % 1000000000;
            }
        }

        else {
            for (int i = 2; i <= n; i++) {
                fibo[i] = (fibo[i-2] + fibo[i-1]) % 1000000000;
            }
        }

        return fibo[n];
    }

    public void solution() {
        int n = sc.nextInt();

        fibo[0] = 0;
        fibo[1] = 1;

        int res = dp(n);

        if (res == 0) {
            System.out.println(0);
            System.out.println(0);
        }

        else if (res < 0) {
            System.out.println(-1);
            System.out.println(Math.abs(res));
        }

        else {
            System.out.println(1);
            System.out.println(Math.abs(res));
        }
    }

    public static void main(String[] args) {
        new Main().solution();
    }
}
