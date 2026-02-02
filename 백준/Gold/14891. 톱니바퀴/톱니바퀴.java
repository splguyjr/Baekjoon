import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr = new int[5][8];
    static int k;
    static int[] rotateArr = new int[5]; // 12시가 가리키는 원본 인덱스

    private static int mod8(int x) {
        x %= 8;
        if (x < 0) x += 8;
        return x;
    }

    private static int rightTooth(int i) { // 3시
        return arr[i][mod8(rotateArr[i] + 2)];
    }

    private static int leftTooth(int i) { // 9시
        return arr[i][mod8(rotateArr[i] + 6)];
    }

    private static void rotate(int n, int d) {
        int[] dirs = new int[5]; // 이번 명령에서 각 기어 회전 방향
        dirs[n] = d;

        // 왼쪽 전파: (i-1)과 i 비교 => (i-1)의 3시 vs i의 9시
        for (int i = n; i >= 2; i--) {
            if (rightTooth(i - 1) != leftTooth(i)) {
                dirs[i - 1] = -dirs[i];
            } else {
                break;
            }
        }

        // 오른쪽 전파: i와 (i+1) 비교 => i의 3시 vs (i+1)의 9시
        for (int i = n; i <= 3; i++) {
            if (rightTooth(i) != leftTooth(i + 1)) {
                dirs[i + 1] = -dirs[i];
            } else {
                break;
            }
        }

        // 회전 "동시에" 적용 (여기서만 rotateArr 갱신)
        for (int i = 1; i <= 4; i++) {
            if (dirs[i] == 1) {          // 시계
                rotateArr[i] = mod8(rotateArr[i] - 1); // top이 한 칸 이전 인덱스로
            } else if (dirs[i] == -1) {  // 반시계
                rotateArr[i] = mod8(rotateArr[i] + 1);
            }
        }
    }

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            rotate(num, dir);
        }
    }

    private static void calFinalScore() {
        int ans = 0;
        for (int i = 1; i <= 4; i++) {
            int topIdx = rotateArr[i];
            if (arr[i][topIdx] == 1) ans += (1 << (i - 1));
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        readInput();
        calFinalScore();
    }
}
