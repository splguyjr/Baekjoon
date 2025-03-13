import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] dist;
    static int[] cityCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dist = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        cityCost = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int curCost = 1000000001;
        long ans = 0;
        // 앞에서부터 해당 도시의 가격 체크하여 최소면 갱신
        for (int i = 0; i < N - 1; i++) {
            if (cityCost[i] < curCost) curCost = cityCost[i];
            ans += (long) curCost * dist[i];
        }

        System.out.println(ans);
    }
}