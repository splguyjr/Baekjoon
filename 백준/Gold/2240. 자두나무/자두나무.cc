#include <iostream>
#include <algorithm>

using namespace std;

int t, w;
int dp[1002][32][3];//시간,이동횟수,위치
int fall[1002];
int ans;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> t >> w;

	for (int i = 1; i <= t; i++) {
		cin >> fall[i];
	}
	
	dp[1][0][1] = (fall[1] == 1);
	dp[1][1][2] = (fall[1] == 2);

	ans = max(dp[1][0][1], dp[1][1][2]);
	for (int i = 2; i <= t; i++) {
		for (int j = 0; j <= w; j++) {
			
			dp[i][j][1] = max(dp[i - 1][j][1], dp[i - 1][j - 1][2]) + (fall[i] == 1);
			dp[i][j][2] = max(dp[i - 1][j][2], dp[i - 1][j - 1][1]) + (fall[i] == 2);
			
			ans = max({ ans, dp[i][j][1], dp[i][j][2] });
			
		}
	}

	cout << ans;

	return 0;
}