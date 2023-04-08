#include <iostream>
#include <algorithm>

#define INF 987654321;

using namespace std;


int n;
long long dp[3][100001];
int a, b, c;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	

	for (int t=1; ; t++) {
	cin >> n;

	if (n == 0) break;

	cin >> a >> b >> c;

	dp[0][1] = INF;
	dp[1][1] = b;
	dp[2][1] = dp[1][1] + c;

	for (int i = 2; i <= n; i++) {
		cin >> a >> b >> c;
		dp[0][i] = min(dp[0][i - 1], dp[1][i - 1]) + a;
		dp[1][i] = min({ dp[0][i - 1], dp[1][i - 1], dp[2][i - 1], dp[0][i] }) + b;
		dp[2][i] = min({ dp[1][i - 1], dp[2][i - 1],dp[1][i] }) + c;
	}

	cout << t << ". " << dp[1][n] << '\n';

	}

	return 0;
}