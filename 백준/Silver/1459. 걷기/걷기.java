import java.util.Scanner;

public class Main {

    static int x, y, w, s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        w = sc.nextInt();
        s = sc.nextInt();

        long hori = Math.abs(x- y);
        long diag = x > y ? x - hori : y - hori;

        long ans = 0;

        if (w > s) {
            ans = diag * s + hori / 2 * 2 * s + hori % 2 * w;
        }

        else if (s > 2 * w) {
            ans = (long) (x + y) * w;
        }

        else {
            ans = diag * s + hori * w;
        }

        System.out.println(ans);
    }
}
