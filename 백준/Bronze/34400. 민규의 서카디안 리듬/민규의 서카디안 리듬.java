import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int x = Integer.parseInt(br.readLine()) % 25;
            if (x >= 0 && x < 17) sb.append("ONLINE\n");
            else sb.append("OFFLINE\n");
        }

        System.out.println(sb.toString());
    }
}
