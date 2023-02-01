d = list(map(int, input()))
l = len(d)
dp = [0 for _ in range(l+1)]

if(d[0] == 0):
    print("0")
else:
    d = [0] + d
    dp[0] = 1
    dp[1] = 1
    for i in range (2, l+1):
        temp = d[i-1]*10 + d[i]
        if(d[i] > 0):
            dp[i] += dp[i-1]
        if(temp >= 10 and temp<= 26):
            dp[i] += dp[i-2]
    print(dp[l]%1000000)