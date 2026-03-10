import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        StringBuilder c = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            c.append(a.charAt(i));
            c.append(b.charAt(i));
        }
        String s = c.toString();

        for (int i = 0; i < 14; i++) {
            String temp = "";
            for (int j = 0; j < s.length() - 1; j++) {
                int x = s.charAt(j) - '0';
                int y = s.charAt(j + 1) - '0';
                int z = (x + y) % 10;

                temp += (char)(z + '0');
            }
            s = temp;
        }
        
        System.out.println(s);
    }
}
