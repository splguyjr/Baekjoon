import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int t;
    static Map<String, String> parentMap;
    static Map<String, Integer> countMap;

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int f = Integer.parseInt(br.readLine());

            parentMap = new HashMap<>();
            countMap = new HashMap<>();

            for (int j = 0; j < f; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();

                parentMap.put(s1, parentMap.getOrDefault(s1, s1));
                parentMap.put(s2, parentMap.getOrDefault(s2, s2));

                countMap.put(s1, countMap.getOrDefault(s1, 1));
                countMap.put(s2, countMap.getOrDefault(s2, 1));

                union(s1, s2);
            }
        }

    }

    private static String find(String s) {
        if (!s.equals(parentMap.get(s))) {
            parentMap.put(s, find(parentMap.get(s)));
        }
        return parentMap.get(s);
    }

    private static void union(String s1, String s2) {
        String p1 = find(s1);
        String p2 = find(s2);

        if (!p1.equals(p2)) {
            parentMap.put(p1, p2);
            int cnt1 = countMap.get(p1);
            int cnt2 = countMap.get(p2);

            countMap.put(p2, cnt1 + cnt2);
        }

        System.out.println(countMap.get(p2));
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
