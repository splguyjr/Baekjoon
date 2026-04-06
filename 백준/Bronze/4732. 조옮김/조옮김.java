import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] arr = new String[] {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};

        Map<String, Integer> map = new HashMap<>();

        map.put("A", 0);
        map.put("A#", 1); map.put("Bb", 1);

        map.put("B", 2); map.put("Cb", 2);

        map.put("C", 3); map.put("B#", 3);

        map.put("C#", 4); map.put("Db", 4);

        map.put("D", 5);

        map.put("D#", 6); map.put("Eb", 6);

        map.put("E", 7); map.put("Fb", 7);

        map.put("F", 8); map.put("E#", 8);

        map.put("F#", 9); map.put("Gb", 9);

        map.put("G", 10);

        map.put("G#", 11); map.put("Ab", 11);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = br.readLine()).equals("***")) {
            StringTokenizer st = new StringTokenizer(s);

            int n = Integer.parseInt(br.readLine()) + 12;
            while (st.hasMoreElements()) {
                String c = st.nextToken();

                int idx = map.get(c);
                System.out.print(arr[(idx + n) % arr.length] + " ");
            }

            System.out.println();
        }
    }
}
