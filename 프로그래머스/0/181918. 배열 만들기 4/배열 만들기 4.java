import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int size = arr.length;
        
        
        List<Integer> list = new ArrayList();
        int idx = 0;
        while (idx < size) {
            if (list.isEmpty()) {
                list.add(arr[idx]);
                idx++;
            }
            else if (list.get(list.size() - 1) < arr[idx]) {
                list.add(arr[idx]);
                idx++;
            }
            else {
                list.remove(list.size() - 1);
            }
        }
        
        int[] stk = list.stream().mapToInt(i->i).toArray();
        
        return stk;
    }
}