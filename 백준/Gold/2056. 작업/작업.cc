#include <iostream>
#include <algorithm>

using namespace std;

int n;
int dp[10001];
int cost, cnt;
int ans = 0;

int main() {

	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> cost >> cnt;

		if (cnt == 0) {
			dp[i] = cost;
			continue;
		}

		int tmp;
		for (int j = 0; j < cnt; j++) {
			cin >> tmp;
			dp[i] = max(dp[i], dp[tmp]);
		}

		dp[i] += cost;
	}

	for (int i = 1; i <= n; i++) {
		ans = max(ans, dp[i]);
	}

	cout << ans;
}