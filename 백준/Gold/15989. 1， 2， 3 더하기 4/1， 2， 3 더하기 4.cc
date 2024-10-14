#include <iostream>

using namespace std;

int dp[10001][4];
int t,n;

void solution() {
	dp[0][1] = 1;
	dp[1][1] = 1;

	//오름차순 기준에서 끝이 2로 끝나는 경우, 앞에는 1과 2만 올 수 있음
	for (int i = 2; i <= 10000; i++) {
		dp[i][1] = dp[i - 1][1];
		dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
		if (i >= 3)
			dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
 	}
}

int main() {
	solution();

	cin >> t;
	while(t--) {
		cin >> n;
		cout << dp[n][1] + dp[n][2] + dp[n][3] << '\n';
	}
	
	return 0;
}