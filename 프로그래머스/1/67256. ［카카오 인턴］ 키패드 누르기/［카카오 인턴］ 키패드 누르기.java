class Solution {
    public String solution(int[] numbers, String hand) {
        int left = 10, right = 12;   // *, #
        StringBuilder sb = new StringBuilder();

        for (int num : numbers) {
            int target = (num == 0) ? 11 : num;
            char pick;

            if (target % 3 == 1) {
                pick = 'L';
            } else if (target % 3 == 0) {
                pick = 'R';
            } else {
                int dl = dist(left, target);
                int dr = dist(right, target);
                if (dl < dr) pick = 'L';
                else if (dr < dl) pick = 'R';
                else pick = hand.equals("left") ? 'L' : 'R';
            }

            if (pick == 'L') left = target;
            else right = target;
            sb.append(pick);
        }
        return sb.toString();
    }

    private int dist(int a, int b) {
        return Math.abs((a - 1) / 3 - (b - 1) / 3)
             + Math.abs((a - 1) % 3 - (b - 1) % 3);
    }
}