import java.util.Scanner;

public class Main {

    static String today;
    static String dDay;
    static int year1, month1, day1;
    static int year2, month2, day2;

    private static int monthDay(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return checkLeapYear(year) ? 29 : 28;
            default:
                return 0;
        }
    }


    private static boolean checkLeapYear(int year) {
        if (year % 400 == 0) return true;
        else if (year % 100 == 0) return false;
        else if (year % 4 == 0) return true;
        return false;
    }

    private static boolean checkGiveUp() {
        String[] sarr1 = today.split(" ");
        String[] sarr2 = dDay.split(" ");

        year1 = Integer.parseInt(sarr1[0]);
        month1 = Integer.parseInt(sarr1[1]);
        day1 = Integer.parseInt(sarr1[2]);

        year2 = Integer.parseInt(sarr2[0]);
        month2 = Integer.parseInt(sarr2[1]);
        day2 = Integer.parseInt(sarr2[2]);

        if (year2 - year1 == 1000) {
            if (month2 > month1) return true;
            else if (month2 == month1) return day1 <= day2;
        }

        else return year2 - year1 > 1000;
        return false;
    }

    private static int convertToDays(int year, int month, int day) {
        int days = 0;

        for (int i = 1; i < year; i++) {
            days += checkLeapYear(i) ? 366 : 365;
        }

        for (int i = 1; i < month; i++) {
            days += monthDay(year, i);
        }

        days += day;

        return days;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        today = sc.nextLine();
        dDay = sc.nextLine();

        if (checkGiveUp()) System.out.println("gg");

        else {
            int st = convertToDays(year1, month1, day1);
            int ed = convertToDays(year2, month2, day2);

            System.out.print("D-");
            System.out.println(ed - st);
        }

    }
}
