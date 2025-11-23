import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 곡 개수
        int l = sc.nextInt();   // 곡 길이
        int d = sc.nextInt();   // 전화 주기

        int total = n * l + 5 * (n - 1);

        int time = 0;

        while (true) {
            if (time > total) {
                System.out.println(time);
                break;
            }

            else {
                boolean inSong = false;

                for (int i = 0; i < n; i++) {
                    int st = i * (l + 5);
                    int ed = st + l;

                    if (time >= st && time < ed) {
                        inSong = true;
                        break;
                    }
                }

                if (!inSong) {
                    System.out.println(time);
                    break;
                }

                time += d;
            }
        }

        sc.close();
    }
}
