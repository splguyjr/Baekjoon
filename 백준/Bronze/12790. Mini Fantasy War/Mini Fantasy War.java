import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        int hp, mp, at, de;
        int eqhp, eqmp, eqat, eqde;

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            hp = Integer.parseInt(st.nextToken());
            mp = Integer.parseInt(st.nextToken());
            at = Integer.parseInt(st.nextToken());
            de = Integer.parseInt(st.nextToken());
            eqhp = Integer.parseInt(st.nextToken());
            eqmp = Integer.parseInt(st.nextToken());
            eqat = Integer.parseInt(st.nextToken());
            eqde = Integer.parseInt(st.nextToken());

            hp = Math.max(1, hp + eqhp);
            mp = Math.max(1, mp + eqmp);
            at = Math.max(0, at + eqat);
            de += eqde;

            System.out.println(hp + 5 * mp + 2 * at + 2 * de);
        }
    }
}
