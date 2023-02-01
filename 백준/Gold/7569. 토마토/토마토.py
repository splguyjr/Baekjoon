import sys
from collections import deque
m,n,h = map(int, input().split()) # m가로, n세로, h높이
dx = [1,-1,0,0,0,0]
dy = [0,0,1,-1,0,0]
dz = [0,0,0,0,1,-1]
tomato = []
queue = deque()
ans = 0

def bfs():
    global ans
    while queue:
        x,y,z = queue.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            
            if(0<=nx<h and 0<=ny<n and 0<=nz<m):
                if(tomato[nx][ny][nz]==0):
                    queue.append([nx, ny, nz])
                    tomato[nx][ny][nz]  = tomato[x][y][z]+1
                    ans = tomato[nx][ny][nz]
    

for i in range(h):
    temp = []
    for j in range(n):
        temp.append(list(map(int, sys.stdin.readline().split())))
        for k in range(m):
            if temp[j][k]==1:
                queue.append([i,j,k])
    tomato.append(temp)

bfs()

for i in range(h):
    for j in range(n):
        for k in range(m):
            if tomato[i][j][k] == 0:
                print(-1)
                exit(0)


if(ans > 0):
    print(ans-1)
else:
    print(ans)
