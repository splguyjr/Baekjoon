from itertools import combinations, chain
from collections import deque
import copy

n, m = list(map(int, input().split()))
graph =[]
for i in range(n):
    graph.append(list(map(int, input().split())))

dx = [1, -1, 0,0]
dy = [0, 0, -1, 1]

def bfs(graph3, root):
    visited = []
    queue = deque([root])

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if(nx <0 or ny <0 or nx >= n or ny >= m or graph3[nx][ny] != 0): continue

            graph3[nx][ny] = 2
            queue.append((nx,ny))


zero = [(x,y) for x in range(n) for y in range(m) if graph[x][y] == 0]
combi = list(combinations(zero, 3))
sum_max = -1
for i in combi:
    graph2 = copy.deepcopy(graph)
    for a,b in i:
        graph2[a][b] = 1
    for v in range(n):
        for w in range(m):
            if(graph2[v][w] == 2): bfs(graph2, (v,w))
    
    sum_max = max(sum_max, sum(graph2, []).count(0))

print(sum_max)