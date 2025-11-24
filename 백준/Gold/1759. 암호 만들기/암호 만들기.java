import java.util.*;

public class Main {

    static int l, c;
    static int[] visited = new int[26];
    static String[] arr;
    static List<String> ans = new ArrayList<>();

    private static void readInput() {
        Scanner sc = new Scanner(System.in);

        l = sc.nextInt();
        c = sc.nextInt();

        sc.nextLine();

        arr = sc.nextLine().split(" ");
        Arrays.sort(arr, Comparator.naturalOrder());

        sc.close();
    }

    private static boolean checkVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }

    private static void dfs(int cnt, int[] visited, int vowelCount, int consoCount, String s, char before) {

        if (cnt == l) {
            if (vowelCount >= 1 && consoCount >= 2) ans.add(s);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i].charAt(0);

            if (visited[c - 'a'] == 1) continue;

            else if (before > c) continue;

            else {
                visited[c - 'a'] = 1;
                if (checkVowel(c)) {
                    dfs(cnt + 1, visited, vowelCount + 1, consoCount, s + c, c);
                    visited[c - 'a'] = 0;
                }
                else {
                    dfs(cnt + 1, visited, vowelCount, consoCount + 1, s + c, c);
                    visited[c - 'a'] = 0;
                }
            }
        }
    }

    private static void printAnswer() {
        ans.sort((s1, s2) -> s1.compareTo(s2));

        StringBuilder sb = new StringBuilder();

        for (String s : ans) {
            sb.append(s).append("\n");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        
        System.out.println(sb);
    }

    private static void solution() {
        readInput();
        dfs(0, visited, 0, 0, "", '0');
        printAnswer();
    }

    public static void main(String[] args) {
        Main.solution();
    }
}
