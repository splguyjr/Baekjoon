#include <iostream>
#include <algorithm>


using namespace std;

int n;
long long dp[101];

int main() {
	cin >> n;

	for (int i = 1; i <= 6; ++i) {
		dp[i] = i;
	}

	for (int i = 7; i <= n; ++i) {
		for (int j = 3; i - j > 0; ++j) {
			dp[i] = max(dp[i], (j - 1) * dp[i - j]);
		}
	}

	cout << dp[n];

	return 0;
}