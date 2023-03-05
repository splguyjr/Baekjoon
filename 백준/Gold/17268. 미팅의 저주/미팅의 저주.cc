#include <iostream>

using namespace std;

long long dp[10001];
int n;

int main() {
	cin >> n;

	dp[0] = 1;
	dp[2] = 1;
	dp[4] = 2;

	for (int i = 3; i <= n / 2; ++i) {
		for (int j = 0; j < i; j++) {
			dp[2 * i] += dp[2 * j] * dp[2 * i - 2 * j - 2];
			dp[2 * i] %= 987654321;
		}
	}
	
	cout << dp[n];

	return 0;
}