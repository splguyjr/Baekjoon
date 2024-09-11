#include <iostream>

using namespace std;

int dp[1000001];

int a, b, d, n;
int ans;

int main() {
	cin >> a >> b >> d >> n;

	for (int i = 0; i < a; i++) {
		dp[i] = 1;
	}

	for (int i = a; i <= n; i++) {
		dp[i] = (dp[i - 1] + dp[i - a]) % 1000;

		if (b <= i) {
			dp[i] = (dp[i] - dp[i - b] + 1000) % 1000;
		}
	}
	ans = dp[n];

	if (n >= d) {
		ans = (dp[n] + 1000 - dp[n - d]) % 1000;
	}

	cout << ans;

	return 0;
}