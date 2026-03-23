import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int n, m;
    static String before, after;
    static String[] arr;
    static Map<String, Integer> hm = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new String[n];

        int idx = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();

            if (arr[i].equals("?")) {
              idx = i;
            }

            else {
                hm.put(arr[i], 1);
            }
        }

        if (idx > 0) before = arr[idx - 1];
        if (idx < n - 1) after = arr[idx + 1];

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            boolean ok = true;

            if (before != null) {
                char c1 = before.charAt(before.length() - 1);
                if (s.charAt(0) != c1) ok = false;
            }

            if (after != null) {
                char c2 = after.charAt(0);
                if (s.charAt(s.length() - 1) != c2) ok = false;
            }

            if (ok && hm.getOrDefault(s, 0) != 1) {
                System.out.println(s);
                break;
            }
        }

    }
}
