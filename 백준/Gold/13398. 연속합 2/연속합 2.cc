#include <iostream>
#include <algorithm>

using namespace std;

int n;
int arr[100001];
int dp[2][100001];
int ans = -1e9;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}

	dp[0][1] = arr[1];
	dp[1][1] = arr[1];
	ans = max(ans,arr[1]);

	for (int i = 2; i <= n; i++) {
		dp[0][i] = max(dp[0][i - 1] + arr[i], arr[i]);
		dp[1][i] = max(dp[0][i - 1], dp[1][i - 1] + arr[i]);
		ans = max({ ans,dp[0][i], dp[1][i] });
	}

	cout << ans;

	return 0;
}