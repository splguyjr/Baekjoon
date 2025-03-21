class Solution {
    //좌표 평면 0~10으로 잡음, 좌표 기준 L, D, U, R <-> 0, 1, 2, 3
    //(x,y)의 L 방문 -> (x-1, y)의 R 방문
    //(x,y)의 R 방문 -> (x+1, y)의 L 방문
    //(x,y)의 U 방문 -> (x, y+1)의 D 방문
    //(x,y)의 D 방문 -> (x, y-1)의 U 방문
    //다만 0~10 범위의 좌표를 방문하는지 검사해야하고 업데이트가 이루어질 경우에만 count + 1
    static int[][][] visited = new int[11][11][4];
    //L, D, U, R <-> 0, 1, 2, 3과 대응
    static int[] dx = {-1, 0, 0 ,1};
    static int[] dy = {0, -1, 1 ,0};
    static int x = 5;
    static int y = 5;
    static int answer = 0;
    
    public int solution(String dirs) {
        
        for (char dir : dirs.toCharArray()) {
            System.out.println("x : " + x + "       y : " + y);
            if (dir == 'L') {
                if(checkRange(x, y, 0)) {
                    if(visited[x][y][0] != 1) {
                        visited[x][y][0] = 1;
                        visited[x-1][y][3] = 1;
                        answer++;
                    }
                    move(0);
                }
            }
            else if (dir == 'D') {
                if(checkRange(x, y, 1)) {
                    if(visited[x][y][1] != 1) {
                        visited[x][y][1] = 1;
                        visited[x][y-1][2] = 1;
                        answer++;
                    }
                    move(1);
                }
            }
            else if (dir == 'U') {
                if(checkRange(x, y, 2)) {
                    if(visited[x][y][2] != 1) {
                        visited[x][y][2] = 1;
                        visited[x][y+1][1] = 1;
                        answer++;
                    }
                    move(2);
                }
            }
            else if (dir == 'R') {
                if(checkRange(x, y, 3)) {
                    if(visited[x][y][3] != 1) {
                        visited[x][y][3] = 1;
                        visited[x+1][y][0] = 1;
                        answer++;
                    }
                    move(3);
                }
            }
        }
        
        return answer;
    }
    
    private boolean checkRange(int curX, int curY, int dir) {
        int nx = curX + dx[dir];
        int ny = curY + dy[dir];
        
        if (nx < 0 || ny < 0 || nx >= 11 || ny >= 11) {
            return false;
        }
        
       return true;
    }
    
    private void move(int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        
        x = nx;
        y = ny;
    }
    
}