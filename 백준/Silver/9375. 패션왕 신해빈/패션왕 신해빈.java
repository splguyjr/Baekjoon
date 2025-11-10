import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int t, n;
    static Map<String, Integer> hm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            hm = new HashMap<>();

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();

                hm.put(type, hm.getOrDefault(type, 0) + 1);
            }

            // 총 종류가 n개면
            int typeCount = hm.size();
            int combinationCount = 1;


            for (String key : hm.keySet()) {
                int count = hm.get(key);
                combinationCount *= count + 1;
            }

            combinationCount -= 1;

            System.out.println(combinationCount);
        }

        br.close();
    }
}