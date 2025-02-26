class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int[][] blocked = new int[park.length][park[0].length()];//장애물 위치 기록
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};
        
        int r =0, c = 0;//시작 행, 열
        
        for(int i = 0; i<park.length; i++) {
            String s = park[i];
            for(int j = 0; j<s.length(); j++) {
                if(s.charAt(j) == 'S') {
                    r = i; c = j;
                }
                else if (s.charAt(j) == 'X') {
                    blocked[i][j] = 1;
                }
            }
        }
        for(String move : routes) {
                    String[] moveArr = move.split(" ");
                    char direction = moveArr[0].charAt(0);
                    int num = Integer.valueOf(moveArr[1]);
                    int idx = 0;
                    if(direction == 'E') {
                        idx = 1;
                    }
                    else if (direction == 'W') {
                        idx = 2;
                    }
                    else if (direction == 'N') {
                        idx = 0;
                    }
                    else if (direction == 'S') {
                        idx = 3;
                    }
                    
                    for(int cnt = 1; cnt <= num; cnt++) {
                        int nx = r + cnt*dx[idx];
                        int ny = c + cnt*dy[idx];
                        if(nx < 0 || nx >= blocked.length || ny < 0 || ny >= blocked[0].length) break;
                        else if(blocked[nx][ny] == 1) break;
                        
                        
                        if(cnt == num) {
                            r = nx;
                            c = ny;
                            System.out.println(r + " " + c);
                        }
                    }
                }
      
        
        return new int[] {r,c};
    }
}