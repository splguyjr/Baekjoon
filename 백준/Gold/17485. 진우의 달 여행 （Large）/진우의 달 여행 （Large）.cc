#include <iostream>
#include <algorithm>

using namespace std;

int n, m;
int dp[1001][1001][3];
int ans = 100001;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m;

	int cost;

	for (int j = 1; j <= m; j++) {
		cin >> cost;
		dp[1][j][0] = cost;
		dp[1][j][1] = cost;
		dp[1][j][2] = cost;
	}

	/*for (int j = 1; j <= m; j++) {
		cin >> cost;
		if (j == 1) {
			dp[2][j][1] = dp[1][j][0] + cost;
			dp[2][j][0] = dp[1][j+1][2] + cost;
		}

		else if (j == m) {
			dp[2][j][1] = dp[1][j][2] + cost;
			dp[2][j][2] = dp[1][j - 1][1] + cost;
		}

		else {
			dp[2][j][0] = dp[1][j][1] + cost;
			dp[2][j][1] = dp[1][j+1][0] + cost;
			dp[2][j][2] = dp[1][j - 1][1] + cost;
		}
	}*/

	for (int i = 2; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> cost;
			if (j == 1) {
				dp[i][j][1] = dp[i-1][j][0] + cost;
				dp[i][j][0] = min(dp[i-1][j+1][1], dp[i - 1][j+1][2]) + cost;
			}

			else if (j == m) {
				dp[i][j][1] = dp[i-1][j][2] + cost;
				dp[i][j][2] = min(dp[i-1][j - 1][0], dp[i - 1][j - 1][1]) + cost;
			}
			
			else {
				dp[i][j][0] = min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + cost;
				dp[i][j][1] = min(dp[i - 1][j][0], dp[i - 1][j][2]) + cost;
				dp[i][j][2] = min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + cost;
			}
		}
	}

	for (int j = 1; j <= m; j++) {
		for (int k = 0; k <= 2; k++) {
			if (dp[n][j][k] > 0) ans = min(ans, dp[n][j][k]);
		}
	}
	
	cout << ans;

	return 0;
}