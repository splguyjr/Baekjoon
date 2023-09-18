#include <iostream>
#include <algorithm>

using namespace std;

int n, t, k, s;//단원 개수 n, 총 시간 t
int dp[101][10001];

int main() {
	cin >> n >> t;

	for (int i = 1; i <= n; i++) {
		cin >> k >> s; //각 단원 별 예상 공부 시간 k, 배점 s
		for (int j = 1; j <= t; j++) {
			if (j < k) dp[i][j] = dp[i - 1][j];
			else { dp[i][j] = max(dp[i - 1][j - k] + s, dp[i - 1][j]); }
		}
	}



	cout << dp[n][t];



	return 0;
}