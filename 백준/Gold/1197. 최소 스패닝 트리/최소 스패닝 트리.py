import sys
import heapq
input = sys.stdin.readline


v, e = map(int, input().split())
g = [[] for _ in range(v+1)]

for _ in range(e):
    a,b,c = map(int, input().split())
    g[a].append((c, b))
    g[b].append((c, a))#가중치를 힙 우선순위로 두기 위해 c가 먼저

q = g[1]
visited = [True, True] + [False]*(v-1)
heapq.heapify(q)

ans = 0
while q:
    c, dest = heapq.heappop(q)
    if not visited[dest]:
        visited[dest] = True
        ans += c
        for e in g[dest]:
            if not visited[e[1]]:
                heapq.heappush(q,e)

print(ans)


#https://cme10575.tistory.com/119 힙을 이용한 prim