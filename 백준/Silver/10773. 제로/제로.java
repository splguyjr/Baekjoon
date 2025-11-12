import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int k;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                dq.removeFirst();
            }

            else {
                dq.offerFirst(x);
            }
        }

        int sum = 0;

        while (!dq.isEmpty()) {
            sum += dq.pollFirst();
        }

        System.out.println(sum);
    }
}