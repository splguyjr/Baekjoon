class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        
        boolean flag = false;
        for(int i = 0; i < my_string.length(); i++) {
            if(my_string.substring(i,my_string.length()).equals(is_suffix)) {
                flag = true;
                break;
            }
        }
        if(flag) return 1;
        return 0;
    }
}