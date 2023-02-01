n = int(input())
priority = [[0 for _ in range(2)] for _ in range(6)]
dp = [ [ [0 for _ in range(31)]for _ in range (3) ]for _ in range (3) ]
#dp[출발위치][도착위치][디스크 개수]

x = list(map(str, input().split()))

for i in range(6): # A,B,C 각각 0, 1, 2로 취급하여 priority list에 넣어주기
    for j in range(2):
        if x[i][j] == "A":
            priority[i][j] = 0
        elif x[i][j] == "B":
            priority[i][j] = 1
        else:
            priority[i][j] = 2

for i in range(6): # 1개만 옮길때를 초기화해주기.
    start = priority[i][0]
    end = priority[i][1]
    if(dp[start][0][1] == 0 and dp[start][1][1] == 0 and dp[start][2][1] == 0):
        dp[start][end][1]  = 1


for i in range(2, n+1):
    for st in range(0, 3):
        for en in range(0, 3):
            if(st != en):
                if (dp[st][3-st-en][i-1] & dp[3-st-en][en][i-1]):
                     dp[st][en][i] = dp[st][3-st-en][i-1] + 1 + dp[3-st-en][en][i-1]
                elif (dp[st][en][i-1] & dp[en][st][i-1]):
                    dp[st][en][i] = dp[st][en][i-1] + 1 + dp[en][st][i-1] + 1 + dp[st][en][i-1]
    

if dp[0][1][n] == 0:
    print(dp[0][2][n])
else:
    print(dp[0][1][n])
