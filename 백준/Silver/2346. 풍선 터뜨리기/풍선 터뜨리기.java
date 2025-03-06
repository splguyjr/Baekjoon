import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Integer[] notes = new Integer[n];
        for(int i = 0; i < n; i++) {
            notes[i] = sc.nextInt();
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
    public static String solution(Integer[] notes) {

        //풍선을 Deque에 삽입
        Deque<Balloon> balloons = new ArrayDeque<>();
        for (int i = 0; i < notes.length; i++) {
            balloons.add(new Balloon(i + 1, notes[i]));
        }

        StringBuilder sb = new StringBuilder();

        //첫번째 풍선 터트린 노트값으로 초기화하여 시작
        Balloon poppedBallon = balloons.pollFirst();
        int lastNoteValue = poppedBallon.noteValue;
        sb.append(poppedBallon.order + " ");

        while (!balloons.isEmpty()) {
            //양수값이면 오른쪽으로 이동하여 터트림
            if(lastNoteValue > 0) {
                for (int i = 0; i < lastNoteValue - 1; i++) {
                    Balloon balloon = balloons.pollFirst();
                    balloons.addLast(balloon);
                }
                poppedBallon = balloons.pollFirst();
                lastNoteValue = poppedBallon.noteValue;
                sb.append(poppedBallon.order);
            }

            else {
                lastNoteValue = lastNoteValue * -1;
                for (int i = 0; i < lastNoteValue; i++) {
                    Balloon balloon = balloons.pollLast();
                    balloons.addFirst(balloon);
                }
                poppedBallon = balloons.pollFirst();
                lastNoteValue = poppedBallon.noteValue;
                sb.append(poppedBallon.order);
            }

            if (balloons.isEmpty())
                break;

            sb.append(" ");

        }

        return sb.toString();
    }
}
