#include <iostream>
#include <algorithm>

using namespace std;

int t;
int dp[501][501];
int arr[501];
int sum[501];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> t;

	int n;
	while (t--) {
		cin >> n;

		for (int i = 1; i <= n; i++) {
			cin >> arr[i];
			sum[i] = sum[i-1] + arr[i];
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n-i; j++) {
				dp[j][i + j] = (500 * 501) / 2 * 10000;
				for (int k = j; k< j + i; k++) {
					dp[j][i + j] = min(dp[j][i+j], dp[j][k] + dp[k + 1][i + j] + sum[i + j] - sum[j - 1]);
				}
			}
		}

		cout << dp[1][n] << '\n';
	}



	return 0;
}