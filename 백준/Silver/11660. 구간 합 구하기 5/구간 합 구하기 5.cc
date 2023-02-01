#include <iostream>

using namespace std;

int table[1027][1027];
int dp[1027][1027];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	int n, m;
	int x1, y1, x2, y2;
	int sum = 0;

	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> table[i][j];
			dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + table[i][j];
		}
	}
	
	while (m--) {
		cin >> x1 >> y1 >> x2 >> y2;
		sum = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
		cout << sum << '\n';
	}



	return 0;
}