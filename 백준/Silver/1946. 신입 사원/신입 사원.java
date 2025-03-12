import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] grade = new int[N+1][2];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                int docRank = Integer.parseInt(st.nextToken());
                int intRank = Integer.parseInt(st.nextToken());
                grade[i][0] = docRank;
                grade[i][1] = intRank;
            }

            Arrays.sort(grade, (g1, g2) -> g1[0]- g2[0]);
            int cnt = 1;
            int curDocRank = grade[1][0];
            int curIntRank = grade[1][1];
            for (int i = 2; i <= N; i++) {
                int x = grade[i][0];
                int y = grade[i][1];

                if(x < curDocRank || y < curIntRank) {
                    curDocRank = x;
                    curIntRank = y;
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}