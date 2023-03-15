#include <iostream>
#include <algorithm>

using namespace std;

int n;
int day[1500001];
int pay[1500001];
int dp[1500001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> day[i] >> pay[i];
	}

	for (int i = 1; i <= n; i++) {


		dp[i + day[i]] = max(dp[i]+ pay[i], dp[i + day[i]]);
		dp[i + 1] = max(dp[i], dp[i + 1]);


	}

	cout << dp[n + 1];
}