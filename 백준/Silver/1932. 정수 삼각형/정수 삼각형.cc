#include <iostream>
#include <algorithm>

using namespace std;

int n;
int tri[502][502];
int dp[502][502];
int sum = 0;

int main() {
	cin >> n;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= i; j++) {
			cin >> tri[i][j];
		}
	}

	for (int i = 2; i <= n+1; i++) {
		for (int j = 1; j <= i; j++) {
			if (j == 1) { dp[i][j] += dp[i - 1][j] + tri[i - 1][j]; }
			else if (j == i) { dp[i][j] += dp[i - 1][j - 1] + tri[i - 1][j - 1]; }
			else { dp[i][j] = max(dp[i - 1][j - 1] + tri[i - 1][j - 1], dp[i - 1][j] + tri[i - 1][j]); }
		}
	}

	for (int i = 1; i <= n+1; i++) {
		sum = max(sum, dp[n+1][i]);
	}

	cout << sum;

	return 0;
}