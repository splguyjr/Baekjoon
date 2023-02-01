import math

n = int(input())

dp = [0] * 100001 
dp[1] = 0
dp[2] = 1
ans = 2
for i in range(3, n+1):
    dp[i] = (i-1)*(dp[i-1] + dp[i-2]) %1000000007
    ans = (ans*i)%1000000007

print(ans*dp[n]%1000000007)