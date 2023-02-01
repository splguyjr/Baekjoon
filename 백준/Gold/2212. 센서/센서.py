n = int(input())
k = int(input())
cor = sorted(list(map(int, input().split())))
dis = []
length = 0
for i in range(0, n-1):
    dis.append(cor[i+1]- cor[i])

dis.sort()

for i in range(n-k):
    length = length + dis[i]

print(length)