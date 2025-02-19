class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
        int len = my_string.length();
        for(int i = 0; i< len; i++) {
            if(my_string.substring(0, i).equals(is_prefix)) return 1;
        }
        return 0;
    }
}