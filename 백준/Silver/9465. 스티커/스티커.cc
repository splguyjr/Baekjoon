#include <iostream>
#include <algorithm>

using namespace std;

int t, n;
int sticker[2][100001];
int dp[2][100001];
int ans;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	int x;
	
	dp[0][0] = 0;
	dp[1][0] = 0;

	cin >> t;

	for (int i = 0; i < t; i++) {
		cin >> x;
		for (int j = 0; j < 2; j++) {
			for (int k = 1; k <= x; k++) {
				cin >> sticker[j][k];
			}
		}

		
		
		for (int j = 1; j <= x; j++) {
			dp[0][j] = sticker[0][j] + max(dp[1][j - 1], dp[1][j - 2]);
			dp[1][j] = sticker[1][j] + max(dp[0][j - 1], dp[0][j - 2]);
			}

		cout << max(dp[0][x], dp[1][x]) << '\n';

	}

	return 0;
}