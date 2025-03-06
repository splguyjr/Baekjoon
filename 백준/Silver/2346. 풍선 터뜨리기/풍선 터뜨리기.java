import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] notes = new int[n];
        for(int i=0; i<n; i++) {
            notes[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(notes));

    }

    static class Balloon {
        int order;
        int noteValue;

        Balloon(int order, int noteValue) {
            this.order = order;
            this.noteValue = noteValue;
        }
    }
    public static String solution(int[] notes) {

        //풍선을 Deque에 삽입
        Deque<Balloon> balloons = new ArrayDeque<>();
        for (int i = 0; i < notes.length; i++) {
            balloons.add(new Balloon(i + 1, notes[i]));
        }

        StringBuilder sb = new StringBuilder();

        //첫번째 풍선 터트린 노트값으로 초기화하여 시작

        while (!balloons.isEmpty()) {
            int lastNoteValue = balloons.getFirst().noteValue;
            sb.append(balloons.pollFirst().order);

            if (balloons.isEmpty())
                break;

            sb.append(" ");

            //양수값이면 오른쪽으로 이동하여 터트림
            if(lastNoteValue > 0) {
                for (int i = 0; i < lastNoteValue - 1; i++) {
                    Balloon balloon = balloons.pollFirst();
                    balloons.addLast(balloon);
                }
            }

            else {
                lastNoteValue = lastNoteValue * -1;
                for (int i = 0; i < lastNoteValue; i++) {
                    Balloon balloon = balloons.pollLast();
                    balloons.addFirst(balloon);
                }
            }

        }

        return sb.toString();
    }
}