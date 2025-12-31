import java.util.Scanner;

public class Main {

    static int g, p;
    static int[] plane;  // 인덱스 1부터, 가능한 최대 게이트 번호 저장
    static int[] parent;  // 인덱스 1부터, 가능한 게이트 번호 중 최대를 저장 -> 0 이면 불가능
    static int ans = 0;

    private static void readInput() {
        Scanner sc = new Scanner(System.in);
        g = sc.nextInt();
        p = sc.nextInt();

        plane = new int[p + 1];
        parent = new int[g + 1];

        for (int i = 1; i <= p; i++) {
            plane[i] = sc.nextInt();
        }

        for (int i = 1; i <= g; i++) {
            parent[i] = i;
        }

        sc.close();
    }

    private static int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    private static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx != ry) {
            parent[rx] = ry;
        }
    }

    // 비행기 1번부터 순차적으로 도킹 시뮬레이션
    // 게이트가 한번 쓰이면 해당 번호 -1번 게이트를 쓰도록 가리키고 이것이 0이면 곧바로 종료
    private static void simulate() {
        for (int i = 1; i <= p; i++) {
            int gate = find(plane[i]);
            if (gate == 0) return;
            else {
                ans++;
                union(gate, gate - 1);
            }
        }
    }

    private static void solution() {
        readInput();
        simulate();
        System.out.println(ans);
    }

    public static void main(String[] args) {
        solution();
    }
}
