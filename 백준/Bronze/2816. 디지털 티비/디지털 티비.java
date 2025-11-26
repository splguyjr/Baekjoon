import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] tv = new String[n];

        int k1 = -1;
        int k2 = -1;

        for (int i = 0; i < n; i++) {
            tv[i] = br.readLine();
            if(tv[i].equals("KBS1")) k1 = i;
            else if (tv[i].equals("KBS2")) k2 = i;
        }
        
        StringBuilder sb = new StringBuilder();

        if (k1 < k2) {
            sb.append("1".repeat(k1));
            sb.append("4".repeat(k1));
            sb.append("1".repeat(k2));
            sb.append("4".repeat(k2 - 1));
        }

        else {
            sb.append("1".repeat(k1));
            sb.append("4".repeat(k1));
            sb.append("1".repeat(k2 + 1));
            sb.append("4".repeat(k2));
        }

        System.out.println(sb);
    }
}
