import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        int[] arr = new int[100001];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            for (int j = idx; j < idx + x; j++) {
                arr[j] = i + 1;
            }
            idx += x;
        }

        for (int i = 0; i < q; i++) {
            int y = Integer.parseInt(br.readLine());
            System.out.println(arr[y]);
        }
    }
}
