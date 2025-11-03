import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static final int U = 0, L = 1, R = 2, D = 3;
    static int r, c;
    static int startX, startY;
    static int susX, susY;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static Set<Integer> suspect = new HashSet<>();

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();

            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] == 'M') {
                    startX = i;
                    startY = j;
                }
            }
        }

        br.close();
    }

    private static void findSuspectLocation() {
        for (int i = 0; i < 4; i++) {
            int nx = startX + dx[i];
            int ny = startY + dy[i];

            if (canGo(nx, ny)) dfs(nx, ny);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        char cur = map[x][y];

        for (int i = 0; i < 4; i++) {
            if (!isOpen(cur, i)) continue;

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!isInRange(nx, ny)) continue;

            char next = map[nx][ny];

            if (next == 'M' || next == 'Z') continue;

            if (next == '.') {
                susX = nx;
                susY = ny;
                return;
            }

            if (!visited[nx][ny]) dfs(nx, ny);
        }
    }

    // 해당 방향으로 열려있는지 확인하는 함수
    private static boolean isOpen(char ch, int dir) {
        switch (ch) {
            case '|' : return dir == U || dir == D;
            case '-' : return dir == L || dir == R;
            case '+' : return true;
            case '1' : return dir == R || dir == D;
            case '2' : return dir == U || dir == R;
            case '3' : return dir == U || dir == L;
            case '4' : return dir == L || dir == D;
            case 'M':
            case 'Z':
                return true;
            default:
                return false;
        }
    }

    private static boolean canGo(int x, int y) {
        return isInRange(x, y) && map[x][y] != 'M' && map[x][y] != 'Z' && map[x][y] != '.';
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && 0 <= y && x < r && y < c;
    }


    private static void calcSuspect() {
        for (int i = 0; i < 4; i++) {
            int nx = susX + dx[i];
            int ny = susY + dy[i];

            if (!isInRange(nx, ny)) continue;

            char next = map[nx][ny];

            if (i == U && (next == '|' || next == '+' || next == '1' || next == '4'))
                suspect.add(U);
            if (i == L && (next == '-' || next == '+' || next == '1' || next == '2'))
                suspect.add(L);
            if (i == R && (next == '-' || next == '+' || next == '3' || next == '4'))
                suspect.add(R);
            if (i == D && (next == '|' || next == '+' || next == '2' || next == '3'))
                suspect.add(D);
        }
    }

    private static char guessBlock() {
        if (suspect.size() == 4) return '+';

        else {
            if (suspect.contains(U) && suspect.contains(D)) return '|';
            else if (suspect.contains(L) && suspect.contains(R)) return '-';
            else if (suspect.contains(R) && suspect.contains(D)) return '1';
            else if (suspect.contains(U) && suspect.contains(R)) return '2';
            else if (suspect.contains(U) && suspect.contains(L)) return '3';
            else return '4';
        }
    }

    private static void printAnswer() {
        StringBuilder sb = new StringBuilder();

        sb.append((susX + 1) + " " + (susY + 1) + " " + guessBlock());
        System.out.println(sb);
    }
    private static void solution() throws IOException {
        readInput();
        findSuspectLocation();
        calcSuspect();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}