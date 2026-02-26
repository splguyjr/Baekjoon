import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
//    static int[][] district;
    static int ans = Integer.MAX_VALUE;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void bruteforce() {
        // 1 <= x <= n - 2, 1 < y < n, x + d1 + d2 <= n, y - d1 >= 1, y + d2 <= n

        for (int x = 1; x <= n - 2; x++) {
            for (int y = 2; y < n; y++) {
                for (int d1 = 1; d1 < n - x && y - d1 >= 1; d1++) {
                    for (int d2 = 1; d2 <= n - x - d1 && y + d2 <= n ; d2++) {
                        markArea(x, y, d1, d2);
                    }
                }
            }
        }
    }

    private static void markArea(int x, int y, int d1, int d2) {
        int[][] area = new int[n + 1][n + 1];

        // 1) 5번 구역 경계선 표시
        for (int i = 0; i <= d1; i++) {
            area[x + i][y - i] = 5;                 // (x, y) -> (x+d1, y-d1)
            area[x + d2 + i][y + d2 - i] = 5;       // (x+d2, y+d2) -> (x+d2+d1, y+d2-d1)
        }
        for (int i = 0; i <= d2; i++) {
            area[x + i][y + i] = 5;                 // (x, y) -> (x+d2, y+d2)
            area[x + d1 + i][y - d1 + i] = 5;       // (x+d1, y-d1) -> (x+d1+d2, y-d1+d2)
        }

        // 2) 5번 구역 내부 채우기: 각 행에서 첫 5부터 다음 5까지 5로 칠하기
        for (int r = x + 1; r <= x + d1 + d2 - 1; r++) {
            boolean inside = false;
            for (int c = 1; c <= n; c++) {
                if (area[r][c] == 5) {
                    inside = !inside;          // 경계 만날 때마다 토글
                }
                if (inside) {
                    area[r][c] = 5;            // 첫 경계 이후부터 채움
                }
            }
        }

        // 3) 1~4번 구역 범위대로 채우기 (5가 아닌 곳만)
        // 1번: 1 ≤ r < x + d1, 1 ≤ c ≤ y
        for (int r = 1; r < x + d1; r++) {
            for (int c = 1; c <= y; c++) {
                if (area[r][c] == 5) break;
                area[r][c] = 1;
            }
        }

        // 2번: 1 ≤ r ≤ x + d2, y < c ≤ n  (오른쪽에서 왼쪽으로)
        for (int r = 1; r <= x + d2; r++) {
            for (int c = n; c > y; c--) {
                if (area[r][c] == 5) break;
                area[r][c] = 2;
            }
        }

        // 3번: x + d1 ≤ r ≤ n, 1 ≤ c < y - d1 + d2
        for (int r = x + d1; r <= n; r++) {
            for (int c = 1; c < y - d1 + d2; c++) {
                if (area[r][c] == 5) break;
                area[r][c] = 3;
            }
        }

        // 4번: x + d2 < r ≤ n, y - d1 + d2 ≤ c ≤ n (오른쪽에서 왼쪽으로)
        for (int r = x + d2 + 1; r <= n; r++) {
            for (int c = n; c >= y - d1 + d2; c--) {
                if (area[r][c] == 5) break;
                area[r][c] = 4;
            }
        }

        // 4) 인구 합 계산
        int[] sum = new int[6];
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                sum[area[r][c]] += arr[r][c];
            }
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i <= 5; i++) {
            min = Math.min(min, sum[i]);
            max = Math.max(max, sum[i]);
        }
        ans = Math.min(ans, max - min);
    }

//    private static void markArea(int x, int y, int d1, int d2) {
//        district = new int[n + 1][n + 1];
//
//        // 1 ~ x - 1행까지는 y
//        // x ~ x + d1 - 1행까지 y -1 + ... + y - d1, d1개
//        int cnt1 = y * (x - 1) + d1 * y - (d1 + 1) * d1 / 2;
//
//        // 1 ~ x - 1행까지는 n - y
//        // x ~ x + d2 행까지 n - y + ... + n - y -d2, d2 + 1개
//        int cnt2 = (n - y) * (x - 1) + (d2 + 1) * (n - y) - (d2 + 1) * d2 / 2;
//
//        // x + d1 ~ x + d1 + d2행까지는 y - d1 + d2 -1 + ... + y - d1 - 1 , d2 + 1개
//        // (x + d1 + d2 + 1) ~ n 행까지는 (y - d1 + d2 -1)
//        int cnt3 = (d2 + 1) * (y - d1 - 1) + (d2 + 1) * d2 / 2 + (n - x - d1 - d2) * (y - d1 + d2 - 1);
//
//        // x + d2 + 1 ~ x + d1 + d2행까지는 (n - y - d2 + d1) + ... +  (n - y - d2 + 1), d1개
//        // (x + d1 + d2 + 1) ~ n 행까지는 (n - y - d2 + d1 + 1)
//        int cnt4 = d1 * (n - y - d2) + (d1 + 1) * d1 / 2 + (n - x - d1 - d2) * (n - y - d2 + d1 + 1);
//
//        int cnt5 = n * n - cnt1 - cnt2 - cnt3 - cnt4;
//
//        int min = Math.min(Math.min(Math.min(Math.min(cnt1, cnt2), cnt3), cnt4), cnt5);
//        int max = Math.max(Math.max(Math.max(Math.max(cnt1, cnt2), cnt3), cnt4), cnt5);
//
//        ans = Math.min(ans, max - min);
//    }

    private static void printAnswer() {
        System.out.print(ans);
    }

    private static void solution() throws IOException {
        readInput();
        bruteforce();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
