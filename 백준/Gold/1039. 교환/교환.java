import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, k;
    static boolean[][] visited;
    static int answer = -1;

    static class Node {
        int num;
        int turn;

        Node(int num, int turn) {
            this.num = num;
            this.turn = turn;
        }
    }

    private static void readInput() throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        visited = new boolean[k + 1][1000001];
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n, 0));
        visited[0][n] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.turn == k) {
                answer = Math.max(answer, cur.num);
                continue;
            }

            int len = String.valueOf(cur.num).length();

            for (int i = 0; i < len -1; i++) {
                for (int j = i + 1; j < len; j++) {
                    int result = swap(cur.num, i, j);

                    if (result == -1) continue;

                    if (!visited[cur.turn + 1][result]) {
                        visited[cur.turn + 1][result] = true;
                        q.add(new Node(result, cur.turn + 1));
                    }
                }
            }
        }
    }

    private static int swap(int num, int i, int j) {
        char[] arr = String.valueOf(num).toCharArray();

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        if (arr[0] == '0') return -1;

        return Integer.parseInt(new String(arr));
    }

    private static void printAnswer() {
        System.out.println(answer);
    }

    private static void solution() throws IOException {
        readInput();
        bfs();
        printAnswer();

    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
