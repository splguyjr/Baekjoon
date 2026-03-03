import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int n, m;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Integer[][] arr = new Integer[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.sort(arr[i], (a, b) -> b - a);
        }

        int[] mx = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mx[j] < arr[i][j]) mx[j] = arr[i][j];
            }
        }
        
        int[] score = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mx[j] == arr[i][j]) {
                    score[i]++;
                }
            }
        }
        
        int best = 0;
        for (int i = 0; i < n; i++) {
            best = Math.max(best, score[i]);
        }

        for (int i = 0; i < n; i++) {
            if (score[i] == best) System.out.print(i + 1 + " ");
        }
    }
}
