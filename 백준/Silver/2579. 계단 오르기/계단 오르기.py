n = int(input())
d = [0]* 301
dp = [0] * 301

for i in range (1,n+1):
    d[i] = int(input())

for i in range(1, n+1):
    if(i==1):
        dp[i] = d[1]
    elif(i==2):
        dp[i] = d[1] + d[2]
    else:
        dp[i] = max(dp[i-3]+ d[i-1]+ d[i], dp[i-2]+d[i])


print(dp[n])
