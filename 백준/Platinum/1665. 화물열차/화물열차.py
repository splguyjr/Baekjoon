import sys

n_a = int(input())
pow_0 = pow(10, 4)


A = []

for i in range(n_a):
    start, end = map(int, sys.stdin.readline().split())
    A.append((start, end))

n_b = int(input())

B = []

for i in range(n_b):
    start, end = map(int, sys.stdin.readline().split())
    B.append((start, end))

derivative = []

for i in range(n_a):
    for j in range(n_b):
        derivative.append(((A[i][0] +B[j][0] -2)*pow_0 + 1))
        derivative.append(((A[i][0] +B[j][1] -1)*pow_0 -1))
        derivative.append(((A[i][1] +B[j][0] -1)*pow_0 -1))
        derivative.append(((A[i][1] +B[j][1])*pow_0 + 1))


derivative.sort()


d = 0 # 겹쳐지는 컨테이너의 증감폭(기울기)
cur_block, cur_pos, max_block, max_pos = 0, 0, 0, 0


for i in range (4*n_a*n_b):
    temp = 0
    check = False
    while (((derivative[i]//pow(10,3)) - (derivative[i]//pow(10,4))*10) == 9):
        derivative[i] += 1
        temp -= 1
        check = True

    if(check):
        cur_block += d * (derivative[i]//pow_0- cur_pos)
        cur_pos = derivative[i]//pow_0
        d += temp

    elif(check == False):
        cur_block += d * (derivative[i]//pow_0- cur_pos)
        cur_pos = derivative[i]//pow_0
        d += derivative[i]%pow_0

    if(max_block < cur_block):
        max_block = cur_block
        max_pos = cur_pos

print(max_pos) 