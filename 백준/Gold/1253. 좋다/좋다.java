import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static int cnt = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }

    private static void checkGoodNumber() {
        for (int i = 0; i < n; i++) {
            if (twoPointer(arr[i], i)) cnt++;
        }
    }
    
    // 음수와 양수의 합을 통해 k를 만들어내는 모든 경우의 수를 투 포인터로 탐색하기 위해 양 끝에서부터 좁혀오기
    private static boolean twoPointer(int sum, int idx) {
        int l = 0;
        int r = n - 1;

        while (l < r && r < n) {
            if (l == idx) { l++; continue;}
            if (r == idx) { r--; continue;}

            int s = arr[l] + arr[r];

            if (s == sum) return true;
            else if (s < sum) l++;
            else r--;
        }
        return false;
    }

    private static void printAnswer() {
        System.out.println(cnt);
    }

    private static void solution() throws IOException {
        readInput();
        checkGoodNumber();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
