import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int n, l;

    private static void readInput() throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        l = sc.nextInt();
    }
    
    private static void calc() {

        for (int k = l; k <= 100; k++) {
            long x = n - (long)k * (k - 1) / 2;

            if (x < 0) break;
            if (x % k == 0) {
                long a = x / k;

                StringBuilder sb = new StringBuilder();

                for (long i = a; i < a + k; i++) {
                    sb.append(i);
                    sb.append(' ');
                }

                sb.deleteCharAt(sb.length() - 1);

                System.out.println(sb);
                return;
            }
        }

        System.out.println(-1);
    }

    private static void solution() throws IOException {
        readInput();
        calc();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}