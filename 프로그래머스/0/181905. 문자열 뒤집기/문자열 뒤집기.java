class Solution {
    public String solution(String my_string, int s, int e) {
        char[] c = my_string.toCharArray();
        for(int i = 0; i < c.length; i++) {
            while(s<e) {
                char temp = c[s];
                c[s++] = c[e];
                c[e--] = temp;
            }
        }
        String answer = new String(c);
        return answer;
    }
}