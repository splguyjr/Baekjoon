import java.io.IOException;
import java.util.Scanner;

public class Main {


    static int n, l;
    static int[][] map;
    static int ans = 0;
    static Scanner sc = new Scanner(System.in);

    private static void readInput() throws IOException {
       n = sc.nextInt();
       l = sc.nextInt();

       map = new int[n][n];

       for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
               map[i][j] = sc.nextInt();
           }
       }
    }

    private static boolean checkRow(int idx) {
        boolean[] isIncline = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = map[idx][i] - map[idx][i + 1];

            if (Math.abs(diff) > 1) return false;

            else {
                // 오르막인 경우, 이전의 l개가 평지이고, 공간이 있고, 경사면이 설치된 적이 없는지 확인
                if (diff == -1) {
                    for (int j = 0; j < l; j++) {
                        if (i - j < 0) return false;    // 공간이 없는 경우
                        else if (isIncline[i - j]) return false;     // 이미 경사면이 설치된 칸인 경우
                        else if (map[idx][i] != map[idx][i - j]) return false; else isIncline[i - j] = true;    // 평지가 아닌 경우
                        isIncline[i - j] = true;
                    }
                }

                else if (diff == 1) {
                    // 내리막인 경우, 앞으로의 l개가 평지이고, 공간이 있고, 경사면이 설치된 적이 없는지 확인
                    for (int j = 1 ; j <= l; j++) {
                        if (i + j >= n) return false;
                        else if (isIncline[i + j]) return false;
                        else if (map[idx][i] - 1 != map[idx][i + j]) return false;
                        isIncline[i + j] = true;
                    }
                }
            }
        }
        return true;
    }

    private static boolean checkCol(int idx) {
        boolean[] isIncline = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = map[i][idx] - map[i + 1][idx];

            if (Math.abs(diff) > 1) return false;

            else {
                // 오르막인 경우, 이전의 l개가 평지이고, 공간이 있고, 경사면이 설치된 적이 없는지 확인
                if (diff == -1) {
                    for (int j = 0; j < l; j++) {
                        if (i - j < 0) return false;    // 공간이 없는 경우
                        else if (isIncline[i - j]) return false;     // 이미 경사면이 설치된 칸인 경우
                        else if (map[i][idx] != map[i - j][idx]) return false; else isIncline[i - j] = true;    // 평지가 아닌 경우
                        isIncline[i - j] = true;
                    }
                }

                else if (diff == 1) {
                    // 내리막인 경우, 앞으로의 l개가 평지이고, 공간이 있고, 경사면이 설치된 적이 없는지 확인
                    for (int j = 1 ; j <= l; j++) {
                        if (i + j >= n) return false;
                        else if (isIncline[i + j]) return false;
                        else if (map[i][idx] - 1 != map[i + j][idx]) return false;
                        isIncline[i + j] = true;
                    }
                }
            }
        }
        return true;
    }

    private static void checkMap() {
        for (int i = 0; i < n; i++) {
            if (checkRow(i)) ans++;
            if (checkCol(i)) ans++;
        }
    }

    private static void solution() throws IOException {
        readInput();
        checkMap();
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
