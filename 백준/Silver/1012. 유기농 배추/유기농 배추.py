from collections import deque

dx = [0,0,1,-1]
dy = [1,-1, 0,0]

t = int(input())

def bfs(a,b):
    queue = deque()
    queue.append((a,b))
    visited[a][b] = True

    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if (0<= nx <n and 0<=ny<m and not visited[nx][ny] and map1[nx][ny] == 1):
                visited[nx][ny] = True
                queue.append([nx,ny])
    return


for c in range(t):

    m, n, k = map(int, input().split())
    map1 = [[0] * m for i in range(n)]
    visited = [[False for col in range(m)] for row in range(n)]

    for i in range(k):
        b, a = map(int, input().split())
        map1[a][b] = 1
    
    cnt = 0

    for i in range(n):
        for j in range(m):
            if(map1[i][j] == 1 and (not visited[i][j])):
                bfs(i,j)
                cnt +=1

    print(cnt)       