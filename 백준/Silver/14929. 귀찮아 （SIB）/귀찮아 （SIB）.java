import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] prefix = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] += prefix[i - 1] + arr[i];
        }

        long ans = 0;

        for (int i = 1; i < n; i++) {
            ans += (long) arr[i] * (prefix[n] - prefix[i]);
        }

        System.out.println(ans);
    }
}
