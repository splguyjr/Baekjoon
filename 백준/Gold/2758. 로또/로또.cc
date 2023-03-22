#include <iostream>

using namespace std;

int n, m;
long long dp[11][2001]; // dp[i][j] -> j로 끝나는 숫자 i개 고르는 로또의 가짓수

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	for (int i = 1; i <= 10; i++) {
		for (int j = 1; j <= 2000; j++) {
			long long temp = 0;
			if (i == 1) {
				dp[i][j] = 1;
				continue;
			}
			for (int k = 1; k <= j / 2; k++) {
				dp[i][j] += dp[i - 1][k];
			}	
		}
	}

	int t;
	cin >> t;
	while (t--) {
		cin >> n >> m;
		long long res = 0;
		for (int i = 1; i <= m; i++) {
			res += dp[n][i];
		}
		cout << res << '\n';
	}
	


	return 0;
}