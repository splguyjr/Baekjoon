import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static Map<Integer, Integer> hm = new HashMap<>();  // arr1의 원소 x -> idx(x) 저장
    static int[] arr;
    static List<Integer> list = new ArrayList<>();  // LIS 꼬리값 배열

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            hm.put(Integer.parseInt(st.nextToken()), i);
        }

        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = hm.get(Integer.parseInt(st.nextToken()));
        }
    }

    // 1 4 2 3
    private static void lis() {

        for (int i = 1; i <= n; i++) {
            int idx = binarySearch(arr[i], list);

            if (list.size() == idx) {
                list.add(arr[i]);
            }

            else {
                list.set(idx, arr[i]);
            }
        }
    }

    // list에서 x보다 큰 원소가 있는 가장 첫 위치를 반환(lower_bound)
    private static int binarySearch(int x, List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (x < list.get(mid)) {
                right = mid - 1;
            }

            else {
                left = mid + 1;
            }
        }
        
        return left;
    }

    private static void printAnswer() {
        System.out.println(list.size());
    }

    private static void solution() throws IOException {
        readInput();
        lis();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
