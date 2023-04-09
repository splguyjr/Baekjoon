#include <iostream>
#include <cmath>

using namespace std;

const int mod = 1e9;
int n;
int dp[1000001] = { 1, };

int main() {

	cin >> n;

	for (int i = 1; i <= n; i++) {
		if (i % 2 == 1) {
			dp[i] = dp[i - 1];
		}
		else {
			dp[i] = dp[i - 1] + dp[i / 2];
			dp[i] %= mod;
		}

	}

	cout << dp[n];




	return 0;
}