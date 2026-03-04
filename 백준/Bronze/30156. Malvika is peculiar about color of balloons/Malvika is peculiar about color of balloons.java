import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int t, n;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            String line = br.readLine();
            int cntA = 0;
            int cntB = 0;
            int len = 0;
            for (char c : line.toCharArray()) {
                if (c == 'a') cntA++;
                else cntB++;
                len++;
            }

            if (cntA >= cntB) {
                System.out.println(cntB);
            } else {
                System.out.println(cntA);
            }
        }
    }
}
