import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static void solution() throws IOException {
        int n, m, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] arr2 = new int[m][k];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[n][k];

        for (int a = 0; a < m; a++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    result[i][j] += arr1[i][a] * arr2[a][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
