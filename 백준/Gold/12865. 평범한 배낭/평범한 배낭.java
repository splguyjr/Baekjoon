import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{

    static int[][] dp = new int[101][100001];

    static class product {
        int weight;
        int value;

        public product(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 물건의 개수
        int k = Integer.parseInt(st.nextToken());   // 가방 무게
        product[] products = new product[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            products[i] = new product(w,v);
        }

        Arrays.sort(products, Comparator.comparingInt(p -> p.weight));

        for (int i = 1; i <= n ; i++) {
            int weight = products[i-1].weight;
            int value = products[i-1].value;
            for (int j = 1; j <= k; j++) {
                if(j - weight >= 0)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight] + value);
                else dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[n][k]);
    }
}