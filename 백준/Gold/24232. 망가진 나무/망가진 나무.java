import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] flipCountArr;
    static char[] ans;

    static class Node {
        int idx;
        boolean direction;
        int inputIdx;

        Node(int idx, boolean direction, int inputIdx) {
            this.idx = idx;
            this.direction = direction;
            this.inputIdx = inputIdx;
        }
    }

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        flipCountArr = new int[n + 1];
        ans = new char[n - 1];

        Arrays.fill(ans, '0');

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, true, i));
            graph.get(v).add(new Node(u, false, i));
        }
    }

    private static void dfs(int curIdx, int parentIdx, int count) {
        flipCountArr[curIdx] = count;
        for (Node node : graph.get(curIdx)) {
            if (node.idx == parentIdx) continue;
            if (node.direction) {
                dfs(node.idx, curIdx, count + 1);
            }

            else if (!node.direction) {
                dfs(node.idx, curIdx, count - 1);
            }
        }
    }

    private static int countFromRoot(int idx, int parentIdx) {
        int cnt = 0;

        for (Node node : graph.get(idx)) {
            if (node.idx == parentIdx) continue;

            if (!node.direction) cnt++;
            countFromRoot(node.idx, idx);
        }

        return cnt;
    }

    private static int findMinNode(int[] arr) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;

        for (int i = 1; i <= n; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIdx = i;
            }
        }

        return minIdx;
    }

    private static void propagation(int curIdx, int parentIdx) {
        for (Node node : graph.get(curIdx)) {
            if (node.idx == parentIdx) continue;

            if (!node.direction) {
                ans[node.inputIdx] = '1';
            }
            propagation(node.idx, curIdx);
        }
    }

    private static void printAnswer(char[] carr) {
        StringBuilder sb = new StringBuilder();

        for (char c : carr) {
            sb.append(c);
        }

        System.out.println(sb);
    }

    private static void solution() throws IOException {
        readInput();
        int flipCount = countFromRoot(1, -1);
        dfs(1, -1, flipCount);
        int minNodeIdx = findMinNode(flipCountArr);
        propagation(minNodeIdx, -1);
        printAnswer(ans);
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
