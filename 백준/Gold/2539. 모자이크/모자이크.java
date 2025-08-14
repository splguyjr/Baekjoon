import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int r, c, n; // 행, 열, 사용 가능한 색종이 개수
    static int min, max;
    static int wrongCount;  // 입력 받아야하는 잘못된 위치 개수
    static List<Node> list = new ArrayList<>();

    private static class Node implements Comparable<Node> {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Node n) {
            return this.col - n.col;
        }
    }

    private static void readInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        n = Integer.parseInt(br.readLine());

        wrongCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < wrongCount; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            list.add(new Node(row, col));
            max = Math.max(max, Math.max(row, col));    // 행, 열 길이 중 큰 것을 최대로 기록
        }

        Collections.sort(list);
    }

    // 해당 색종이 크기로 모두 가릴 수 있는지 확인
    private static boolean checkSize(int size) {
        int cnt = 0;
        int col_pos = 0; // 이전까지 가린 마지막 열 위치

        for (int i = 0; i < list.size(); i++) {
            Node cur = list.get(i);

            if (size < cur.row) return false; // 바닥에서부터 가려도 높이가 부족한 경우

            else if (col_pos == 0 || col_pos < cur.col) { // 새로운 색종이로 가려야 하는 경우
                col_pos = cur.col + size - 1; // 마지막으로 커버한 위치가 아니라, 이번에 가리기 시작할 위치부터 더해야 함!
                cnt++;

                if (cnt > n) return false;
            }
        }

        return true;
    }

    private static int binarySearch() {
        min = 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (checkSize(mid)) max = mid - 1; // 가능한 경우, 색종이 크기를 줄여서 시도
            else min = mid + 1; // 불가능한 경우, 색종이 크기를 늘려서 시도
        }

        return min;
    }

    public static void solution() throws IOException {
        readInput();
        int ans = binarySearch();
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}