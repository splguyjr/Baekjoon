import java.util.Scanner;

public class Main {

    static int month, day, year, hour, minute;

    enum Month {
        January(1),
        February(2),
        March(3),
        April(4),
        May(5),
        June(6),
        July(7),
        August(8),
        September(9),
        October(10),
        November(11),
        December(12);

        private final int value;

        Month(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private static void readInput() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String[] sarr = line.split(" ");

        month = Month.valueOf(sarr[0]).getValue();
        day = Integer.parseInt(sarr[1].substring(0, sarr[1].length() - 1));
        year = Integer.parseInt(sarr[2]);

        String[] sarr2 = sarr[3].split(":");
        hour = Integer.parseInt(sarr2[0]);
        minute = Integer.parseInt(sarr2[1]);
    }

    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        else if (year % 100 == 0) return false;
        else if (year % 4 == 0) return true;
        return false;
    }

    private static int monthInDay(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 30;
        }
    }

    private static int countDay(int year, int month, int day) {
        int sum = 0;

        for (int i = 1; i < month; i++) {
            sum += monthInDay(year, i);
        }

        sum += day - 1;

        return sum;
    }

    private static int countMinute(int hour, int minute) {
        return hour * 60 + minute;
    }

    private static void calPercentage(int year, int month, int day, int hour, int minute) {
        int daySum = countDay(year, month, day);
        int minuteSum = countMinute(hour, minute);

        double percentage1 = (double) daySum / (isLeapYear(year) ? 366 : 365);
        double percentage2 = (double) minuteSum / 1440 / (isLeapYear(year) ? 366 : 365);

        System.out.println((percentage1 + percentage2) * 100);
    }

    private static void solution() {
        readInput();
        calPercentage(year, month, day, hour, minute);
    }

    public static void main(String[] args) {
        Main.solution();
    }
}
