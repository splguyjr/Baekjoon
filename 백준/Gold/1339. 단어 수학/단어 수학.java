import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 1. 그냥 브루트포스하기 -> 10! * 80
    // 2. 그리디하게 정렬하기 -> ex) (뒤에서부터의 순서, 등장횟수)로 판단하여 9부터 숫자 부여

    static int n;
    static String[] word;
    static int[] weight = new int[26];
    static Map<Character, Integer> alphaMap = new HashMap<>();
    static int sum = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        word = new String[n];

        for (int i = 0; i < n; i++) {
            word[i] = br.readLine();

            int rank = word[i].length();

            for (char c : word[i].toCharArray()) {
                int idx = c - 'A';
                int w = (int) Math.pow(10, rank - 1);
                weight[idx] += w;
                rank--;
            }
        }

        br.close();
    }
    
    //
    private static void assignNumber() {
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < 26; i++) {
            if (weight[i] > 0) list.add(new int[] {i, weight[i]});
        }
        
        list.sort((a, b) -> Integer.compare(b[1], a[1]));
        
        int digit = 9;
        for (int[] item : list) {
            char alpha = (char)('A' + item[0]);

            alphaMap.put(alpha, digit--);
        }
    }

    private static void calculateSum() {
        for (int i = 0; i < n; i++) {
            String s = word[i];

            int localSum = 0;

            for (char c : s.toCharArray()) {
                localSum *= 10;
                localSum += alphaMap.get(c);
            }

            sum += localSum;
        }
    }

    private static void printAnswer() {
        System.out.println(sum);
    }

    private static void solution() throws IOException {
        readInput();
        assignNumber();
        calculateSum();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
