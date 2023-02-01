#include <iostream>

using namespace std;

int game[101][101];
long long dp[101][101];

int n;

/*
long long calc(int a, int b) {
	int temp = game[a][b];
	if (temp == 0) return 1;
	if (a == n - 1 && b == n - 1) return 1;

		if (a != n-1 && a + temp < n) {
			dp[a + temp][b] += dp[a][b];
			calc(a + temp, b);
		}
		
		if (b != n - 1 && b + temp < n) {
			dp[a][b + temp] += dp[a][b];
			calc(a, b + temp);
		}

	
	
		//return 0;
}*/

int main() {
	cin >> n;
	
	for (int i = 0; i < n; ++i) {
		for(int j =0; j < n; ++j) {
			cin >> game[i][j];
		}
	}

	dp[0][0] = 1;

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {

			int temp = game[i][j];

			if (temp == 0 || dp[i][j] == 0) continue;

			if(i+temp < n) dp[i + temp][j] += dp[i][j];

			if(j+temp < n) dp[i][j + temp] += dp[i][j];

		}

	}

	cout << dp[n - 1][n - 1];
}